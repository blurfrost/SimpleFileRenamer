import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;
import java.util.Scanner;

class Renamer {
    public static void main(String[] args) {
        // ToRename folder exists in the same directory this file is located in
        String folderName = "ToRename";
        Path folderToRenameFrom = Paths.get(folderName);
        System.out.println("Folder Path: " + folderToRenameFrom.toAbsolutePath());

        // request for scanner to proceed with operation
        Scanner confirmScanner = new Scanner(System.in);
        System.out.println("Renaming contents of folder " + folderName + ", input Y to confirm:");
        String input = confirmScanner.nextLine();

        // check for input of Y, else abort the operation
        if (input.equals("Y")) {
            System.out.println("Processing...");
            // recursively go through provided directory to print out each file's name
            try (Stream<Path> stream = Files.walk(folderToRenameFrom)) {
                stream.filter(Files::isRegularFile)
                    .forEach(file -> System.out.println(file.getFileName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Aborting operation");
        }
        confirmScanner.close();
    }
}