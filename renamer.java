import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;
import java.util.Scanner;

class Renamer {
    public static void main(String[] args) {
        

        // request for scanner to proceed with operation
        Scanner scanner = new Scanner(System.in);

        // ToRename folder exists in the same directory this file is located in
        System.out.println("Specify directory name: ");
        String folderName = scanner.nextLine();
        Path folderToRenameFrom = Paths.get(folderName);
        
        // check if the specified path exists
        if (!Files.exists(folderToRenameFrom)) {
            System.err.println("Error: The specified directory does not exist: " + folderToRenameFrom.toAbsolutePath());
            scanner.close();
            return;
        }
        
        // check if it's actually a directory
        if (!Files.isDirectory(folderToRenameFrom)) {
            System.err.println("Error: The specified path is not a directory: " + folderToRenameFrom.toAbsolutePath());
            scanner.close();
            return;
        }
        
        System.out.println("Folder Path: " + folderToRenameFrom.toAbsolutePath());

        System.out.println("Renaming contents of folder " + folderName + ", input Y to confirm:");
        String confirmation = scanner.nextLine();
        System.out.println("Only rename files of a certain name? If yes, specify substring. If no, leave blank (press ENTER)");
        String substrFilter = scanner.nextLine();
        System.out.println("Append anything to the start of the new filename?");
        String startAppend = scanner.nextLine();

        // check for input of Y, else abort the operation
        if (confirmation.equals("Y")) {
            System.out.println("Processing...");
            // recursively go through provided directory and rename each file
            try (Stream<Path> stream = Files.walk(folderToRenameFrom)) {
                stream.filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            Path currFileName = file.getFileName();
                            String currFileNameStr = currFileName.toString();
                            if (substrFilter.isEmpty() || currFileNameStr.contains(substrFilter)) {
                                Files.move(file, file.resolveSibling(startAppend + currFileNameStr.replace(substrFilter, "")));
                                System.out.println("Renamed: " + currFileName);
                            } else {
                                System.out.println("Did not rename " + currFileName + " as it does not match the filter");
                            }
                        } catch (IOException e) {
                            // if current file fails to be renamed, present error message and move on
                            System.err.println("Failed to rename file: " + file.getFileName() + " - " + e.getMessage());
                        }
                    });
            } catch (IOException e) {
                System.err.println("Failed to access directory: " + e.getMessage());
            }
        } else {
            System.out.println("Aborting operation");
        }
        scanner.close();
    }
}