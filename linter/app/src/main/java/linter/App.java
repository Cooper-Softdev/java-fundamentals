/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws IOException {
    Path gatesFilePath;
    if (args.length > 0) {
      gatesFilePath = Paths.get(args[0]).toAbsolutePath();
    } else {
      gatesFilePath = Paths.get("src/main/resources/gates.js");
    }
    String errorMessages = linter(gatesFilePath);
  }

  public static String linter(Path filePath) throws IOException {
    Scanner fileScanner = new Scanner(filePath);
    int lineNumber = 0;
    StringBuilder errorMessages = new StringBuilder("Errors found on lines: ");
    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine();
      lineNumber++;
      boolean noError = (line.equals("") || line.contains("if") || line.contains("else") || line.endsWith("{") || line.endsWith("}") || line.endsWith(";"));
      if (!noError) {
        errorMessages.append("\n").append(lineNumber);
        System.out.println("Line " + lineNumber + ": Missing semicolon.");
      }
    }
    return errorMessages.toString();
  }
}
/*
 * This Java source file was generated by the Gradle 'init' task.
 */

