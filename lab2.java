package lab2;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class lab2 {
  public static void main(String[] args) {
    firstPass(readFile(args[0]));
  }


  private static List<String> readFile(String fileName) {
    File file = new File(fileName);
    List<String> lines = new ArrayList<>();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }

  /**
   * firstPass() will format the code:
   * 1. ignore all empty lines and comments
   * 2. identify the line number for label
   */
  private static void firstPass(List<String> lines) {
    int lineCount = 0;
    List<String> list = new ArrayList<>();
    Map<String, Integer> labels = new HashMap<>();
    for (String line : lines) {
      String trimBlank = line.replaceAll("\\s", "");
      String trimComment = trimBlank.replaceAll("#.*", "");
      if (trimComment.length() != 0) {
        list.add(trimBlank);
      }
    }
    for (int i = 0; i < list.size(); i++) {
      String label = list.get(i).replaceAll(":.*", "");
      if (list.get(i).length() != label.length()){
        labels.put(label, i);
      }
    }
  }

  public static void secondPass() {

  }
}