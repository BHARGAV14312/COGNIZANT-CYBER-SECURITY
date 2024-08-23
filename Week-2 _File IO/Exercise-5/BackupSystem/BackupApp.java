// BackupApp.java
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BackupApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryCopy directoryCopy = new DirectoryCopy();

        // Prompt user for source and target directories
        System.out.print("Enter the source directory path: ");
        Path sourceDir = Paths.get(scanner.nextLine());

        System.out.print("Enter the target directory path: ");
        Path targetDir = Paths.get(scanner.nextLine());

        // Copy the directory
        System.out.println("Starting backup...");
        directoryCopy.copyDirectory(sourceDir, targetDir);

        // Demonstrate error handling by attempting to copy to a read-only or full directory
        // This step is for demonstration purposes and may require special conditions to test
        System.out.println("\nAttempting to copy to a read-only directory or a directory with insufficient space:");
        Path readOnlyDir = Paths.get("read_only_directory");
        Path noSpaceDir = Paths.get("no_space_directory");
        directoryCopy.copyDirectory(sourceDir, readOnlyDir);
        directoryCopy.copyDirectory(sourceDir, noSpaceDir);
    }
}
