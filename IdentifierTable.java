package lab2;

import java.util.HashMap;
import java.util.Map;

public class IdentifierTable {
    public static  Map<String, String> getRTypeTable() {
        HashMap<String, String> rTable = new HashMap();
        rTable.put("add", "100000");
        rTable.put("and", "100100");
        rTable.put("jr", "001000");
        rTable.put("or", "100101");
        rTable.put("slt", "101010");
        rTable.put("sll", "000000");
        rTable.put("sub", "100010");
        return rTable;
    }

    public static Map<String, String> getITypeTable() {
        HashMap<String, String> table = new HashMap<>();
        table.put("addi", "001000");
        table.put("beq", "000100");
        table.put("bne", "000101");
        table.put("lw", "100011");
        table.put("sw", "101011");
        return table;
    }

    public static Map<String, String> getJTypeTable() {
        HashMap<String, String> table = new HashMap<>();
        table.put("j", "000010");
        table.put("jal", "000011");
        return table;
    }

    public static Map<String, String> getRegisterTable() {
        HashMap<String, String> regTable = new HashMap();
        regTable.put(null, "00000");
        regTable.put("zero", "00000");
        regTable.put("0", "00000");
        regTable.put("v0", "00010");
        regTable.put("v1", "00011");
        regTable.put("a0", "00100");
        regTable.put("a1", "00101");
        regTable.put("a2", "00110");
        regTable.put("a3", "00111");
        regTable.put("t0", "01000");
        regTable.put("t1", "01001");
        regTable.put("t2", "01010");
        regTable.put("t3", "01011");
        regTable.put("t4", "01100");
        regTable.put("t5", "01101");
        regTable.put("t6", "01110");
        regTable.put("t7", "01111");
        regTable.put("s0", "10000");
        regTable.put("s1", "10001");
        regTable.put("s2", "10010");
        regTable.put("s3", "10011");
        regTable.put("s4", "10100");
        regTable.put("s5", "10101");
        regTable.put("s6", "10110");
        regTable.put("s7", "10111");
        regTable.put("t8", "11000");
        regTable.put("t9", "11001");
        regTable.put("sp", "11101");
        regTable.put("ra", "11111");
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