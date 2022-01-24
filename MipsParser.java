package lab2;

import java.io.InputStream;
import java.util.*;

public class MipsParser {
  private final InputStream input;
  private final Map<String, Integer> labels;
  private final List<String> instructions;
  private final Map<String, String> rTable = IdentifierTable.getRTypeTable();
  private final Map<String, String> regs = IdentifierTable.getRegisterTable();
  private final Map<String, String> iTable = IdentifierTable.getITypeTable();
  private final Map<String, String> jTable = IdentifierTable.getJTypeTable();

  public MipsParser(InputStream inputStream) {
    this.input = inputStream;
    this.labels = new HashMap<>();
    this.instructions = new ArrayList<>();
  }

  public void parse() {
    List<String> lines = readFile();
    firstPass(lines);
    secondPass();
  }

  /**
   * firstPass() will format the code:
   * 1. ignore all empty lines and comments
   * 2. identify the line number for label
   * then:
   * 1. put the instructions into instruction list in order (no label, spaces, or comments)
   * 2. put the label into labels table as label name : line number
   */

  private void firstPass(List<String> lines) {
    int lineCnt = 0;
    for (String line : lines) {
      String trimBlank = line.replaceAll("\\s", "");
      String trimComment = trimBlank.replaceAll("#.*", "");
      String label = trimComment.replaceAll(":.*", "");
      if (label.length() != trimComment.length()) {
        labels.put(label, lineCnt);
      }
      String notLabel = trimComment.replaceAll(".*:", "");
      if (notLabel.length() != 0) {
        lineCnt ++;
        instructions.add(notLabel);
      }
    }
  }

  /**
   * convert instructions into binaries
   *
   */
  private void secondPass() {
    int lineCnt = 0;
    for (String instruction : instructions) {
      String[] commaDelimited = instruction.split(",");
      try {
        parseCommaDelimitedStrings(commaDelimited, lineCnt);
      } catch (NoSuchInstructionException e) {
        System.out.println("invalid instruction: " + e.getMessage());
        System.exit(0);
      }
      lineCnt ++ ;
    }
  }

  /**
   *
   * @param instructions instruction list. e.g. [jlabel], [jr$ra], [add$t1, $t2, $t3]
   */
  private void parseCommaDelimitedStrings(String[] instructions, int lineCnt) throws NoSuchInstructionException {
    String start = instructions[0];
    if (start.startsWith("lw") || start.startsWith("sw")) {
      transformParseLoadStoreInstruction(instructions);
    } else if (start.startsWith("bne") || start.startsWith("beq")) {
      transformParseBranchInstructions(instructions, lineCnt);
    } else if (!start.startsWith("jr") && (start.startsWith("j") || start.startsWith("jal"))) {
      transformParseJumpInstructions(instructions);
    } else if (start.startsWith("sll")) {
      transformParseShiftInstructions(instructions);
    } else if (start.startsWith("jr")) {
      parseJrInstruction();
    } else {
      parseNormalInstruction(instructions);
    }
  }

  private void parseNormalInstruction(String[] instrucitons) throws NoSuchInstructionException {
    String[] start = instrucitons[0].split("[$]");
    String operation = start[0];
    if (rTable.containsKey(operation)) {
      String rd = start[1];
      String rs = instrucitons[1];
      String rt = instrucitons[2];
      parseRTypeInstruction(operation, rs, rt, rd, 0);
    } else if (iTable.containsKey(operation)) {
      String rt = start[1];
      String rs = instrucitons[1];
      int immediate = Integer.parseInt(instrucitons[2]);
      parseITypeInstruction(operation, rs, rt, immediate);
    } else {
      throw new NoSuchInstructionException(operation);
    }
  }

  private void transformParseShiftInstructions (String[] instructions) {
    String start[] = instructions[0].split("[$]");
    String operation = start[0];
    String rd = start[1];
    String rt = instructions[1].replaceAll("[$]", "");
    int shift = Integer.parseInt(instructions[2]);
    parseRTypeInstruction(operation, null, rt, rd, shift);
  }

  private void parseJrInstruction() {
    parseRTypeInstruction("jr", "ra", null, null, 0);
  }

  private void transformParseJumpInstructions (String[] instructions) {
    if (instructions[0].startsWith("jal")) {
      String label = instructions[0].replaceAll("jal", "");
      int position = labels.get(label);
      System.out.println(jTable.get("jal") + convertIntToBinaryString(position, 26));
    } else {
      String label = instructions[0].replaceAll("j", "");
      int position = labels.get(label);
      System.out.println(jTable.get("j") + convertIntToBinaryString(position, 26));
    }
  }

  private void transformParseLoadStoreInstruction (String[] instructions) {
    String[] start = instructions[0].split("[$]");
    String operation = start[0];
    String rt = start[1];
    String [] second = instructions[1].split("[(]");
    String imm = second[0];
    int immediate = Integer.parseInt(imm);
    String [] third = second[1].split("[$]");
    String rs = third[1].replaceAll("[)]", "");
    parseITypeInstruction(operation, rs, rt, immediate);
  }

  private void transformParseBranchInstructions (String[] instructions, int lineCnt) {
    String[] start = instructions[0].split("[$]");
    String operation = start[0];
    String rs = start[1];
    String rt = instructions[1].substring(1);
    String label = instructions[2];
    int labelPosition = labels.get(label);
    int relativePosition = labelPosition - lineCnt -1;
    parseITypeInstruction(operation, rs, rt, relativePosition);
  }

  private void parseITypeInstruction (String operation, String rs, String rt, int immediate) {
    String imm = convertIntToBinaryString(immediate, 16);
    System.out.println(iTable.get(operation) + " " + regs.get(rs) + " " + regs.get(rt) + " " + imm);
  }

void parseRTypeInstruction (String operation, String rs, String rt, String rd, int shift) {
    System.out.print(convertIntToBinaryString(0, 6));
    System.out.print(regs.get(rs));
    System.out.print(regs.get(rt));
    System.out.print(regs.get(rd));
    System.out.print(convertIntToBinaryString(shift, 5));
    System.out.println(rTable.get(operation));
  }

  private String convertIntToBinaryString(int immediate, int bitCnt) {
    char [] imm = new char[bitCnt];
    int mask = 1;
    for (int i = 0; i < bitCnt; i++) {
      if ((mask & immediate) != 0)
        imm[bitCnt - i - 1] = '1';
      else
        imm[bitCnt - i - 1] = '0';
      mask = mask << 1;
    }
    return String.copyValueOf(imm);
  }

  private List<String> readFile() {
    List<String> lines = new ArrayList<>();
    Scanner scanner = new Scanner(this.input);
    while (scanner.hasNextLine()) {
      lines.add(scanner.nextLine());
    }
    return lines;
  }

}
