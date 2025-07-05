import java.io.File;
import java.util.Scanner;

class Renamer {
    public static void main(String[] args) {
        String folderName = "ToRename";
        File folder = new File(Renamer.class.getResource(folderName).getPath());
        System.out.println("Folder Path: " + folder.getAbsolutePath());

        Scanner confirmScanner = new Scanner(System.in);
        System.out.println("Renaming contents of folder " + folderName + ", input Y to confirm:");
        String input = confirmScanner.nextLine();
        if (input.equals("Y")) {
            System.out.println("processing");
        } else {
            System.out.println("Aborting operation");
        }
        confirmScanner.close();
    }
}