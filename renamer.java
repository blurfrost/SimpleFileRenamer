import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;
import java.util.Scanner;

class Renamer {
    public static void main(String[] args) {
        String folderName = "ToRename";
        File folder = new File(Renamer.class.getResource(folderName).getPath());
        System.out.println("Folder Path: " + folder.getAbsolutePath());
        Path folderToRenameFrom = Paths.get(folder.toString());

        Scanner confirmScanner = new Scanner(System.in);
        System.out.println("Renaming contents of folder " + folderName + ", input Y to confirm:");
        String input = confirmScanner.nextLine();
        if (input.equals("Y")) {
            System.out.println("Processing...");
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