import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FakeCat {
  public static void main(String args[]) {
    if (args.length == 0) {
      readFromStdIn();
    } else {
      for (String filePath : args) {
        readFromFile(filePath);
      }
    }
  }

  private static void readFromStdIn() {
    try (Scanner scanner = new Scanner(System.in)) {
      while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
      }
    }
  }

  private static void readFromFile(String filePath) {
    try {
      String content = new String(Files.readAllBytes(Paths.get(filePath)));
      System.out.print(content);
    } catch (IOException e) {
      System.err.println("Error reading the file " + filePath + ": " + e.getMessage());
    }
  }

}