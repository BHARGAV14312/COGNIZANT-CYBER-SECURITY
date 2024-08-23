// DirectoryCopy.java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class DirectoryCopy {
    public void copyDirectory(Path sourceDir, Path targetDir) {
        try (Stream<Path> stream = Files.walk(sourceDir)) {
            stream.forEach(sourcePath -> {
                Path targetPath = targetDir.resolve(sourceDir.relativize(sourcePath));
                try {
                    if (Files.isDirectory(sourcePath)) {
                        if (!Files.exists(targetPath)) {
                            Files.createDirectory(targetPath);
                        }
                    } else {
                        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while copying the directory: " + e.getMessage());
                }
            });
            System.out.println("Directory copied from " + sourceDir + " to " + targetDir);
        } catch (IOException e) {
            System.out.println("An error occurred while walking the directory: " + e.getMessage());
        }
    }
}
