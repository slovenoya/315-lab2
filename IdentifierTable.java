package lab2;

import java.util.HashMap;

public class IdentifierTable {
    public HashMap<String, String> getTable() {
        HashMap<String, String> ID_TABLE = new HashMap<String, String>();
        ID_TABLE.put("add", "000000");
        ID_TABLE.put("addi", "001000");
        ID_TABLE.put("addiu", "001001");
        ID_TABLE.put("addu", "100001");
        ID_TABLE.put("and", "100100");
        ID_TABLE.put("andi", "001100");
        ID_TABLE.put("beq", "000100");
        ID_TABLE.put("bne", "000101");
        ID_TABLE.put("j", "000010");
        ID_TABLE.put("jal", "000011");
        ID_TABLE.put("jr", "000000");
        ID_TABLE.put("lbu", "100100");
        ID_TABLE.put("lhu", "100101");
        ID_TABLE.put("ll", "110000");
        ID_TABLE.put("lui", "001111");
        ID_TABLE.put("lw", "100011");
        ID_TABLE.put("nor", "000000");
        ID_TABLE.put("or", "000000");
        ID_TABLE.put("ori", "001101");
        ID_TABLE.put("slt", "000000");
        ID_TABLE.put("slti", "001010");
        ID_TABLE.put("sltiu", "001011");
        ID_TABLE.put("sltu", "000000");
        ID_TABLE.put("sll", "000000");
        ID_TABLE.put("srl", "101000");
        ID_TABLE.put("sb", "111000");
        ID_TABLE.put("sc", "101001");
        ID_TABLE.put("sh", "101011");
        ID_TABLE.put("sub", "100010");
        ID_TABLE.put("subu", "100011");

        return ID_TABLE;
    }

}