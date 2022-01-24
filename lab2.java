package lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class lab2 {
  public static void main(String[] args) {
    File file = new File(args[0]);
    try (FileInputStream stream = new FileInputStream(file)) {
      MipsParser parser = new MipsParser(stream);
      parser.parse();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}