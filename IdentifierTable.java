package lab2;

import java.util.HashMap;
import java.util.Map;

public class IdentifierTable {
    public static Map<String, String> rTypeTable = getRTypeTable();
    public static Map<String, String> otherTable = getOtherTypeTable();
    public static Map<String, String> regTable = getRegisterTable();

    private static Map<String, String> getRTypeTable() {
        HashMap<String, String> rTable = new HashMap();
        rTable.put("add", "100000");
        rTable.put("addu", "100001");
        rTable.put("and", "100100");
        rTable.put("jr", "001000");
        rTable.put("nor", "100111");
        rTable.put("or", "100101");
        rTable.put("slt", "101010");
        rTable.put("sltu", "101011");
        rTable.put("sll", "000000");
        rTable.put("srl", "000010");
        rTable.put("sub", "100010");
        rTable.put("subu", "100011");
        return rTable;
    }

    private static Map<String, String> getOtherTypeTable() {
        HashMap<String, String> table = new HashMap<>();
        table.put("addi", "001000");
        table.put("addiu", "001001");
        table.put("andi", "001100");
        table.put("beq", "000100");
        table.put("bne", "000101");
        table.put("j", "000010");
        table.put("jal", "000011");
        table.put("lbu", "100100");
        table.put("lhu", "100101");
        table.put("ll", "110000");
        table.put("lui", "001111");
        table.put("lw", "100011");
        table.put("ori", "001101");
        table.put("slti", "001010");
        table.put("sltiu", "001011");
        table.put("sb", "111000");
        table.put("sc", "101001");
        table.put("sh", "101001");
        table.put("sw", "101011");
        return table;
    }

    private static Map<String, String> getRegisterTable() {
        HashMap<String, String> regTable = new HashMap();
        regTable.put("$zero", "00000");
        regTable.put("$0", "00000");
        regTable.put("$v0", "00010");
        regTable.put("$v1", "00011");
        regTable.put("$a0", "00100");
        regTable.put("$a1", "00101");
        regTable.put("$a2", "00110");
        regTable.put("$a3", "00111");
        regTable.put("$t0", "01000");
        regTable.put("$t1", "01001");
        regTable.put("$t2", "01010");
        regTable.put("$t3", "01011");
        regTable.put("$t4", "01100");
        regTable.put("$t5", "01101");
        regTable.put("$t6", "01110");
        regTable.put("$t7", "01111");
        regTable.put("$s0", "10000");
        regTable.put("$s1", "10001");
        regTable.put("$s2", "10010");
        regTable.put("$s3", "10011");
        regTable.put("$s4", "10100");
        regTable.put("$s5", "10101");
        regTable.put("$s6", "10110");
        regTable.put("$s7", "10111");
        regTable.put("$t8", "11000");
        regTable.put("$t9", "11001");
        regTable.put("$sp", "11101");
        regTable.put("$ra", "11111");
        return regTable;
    }
}