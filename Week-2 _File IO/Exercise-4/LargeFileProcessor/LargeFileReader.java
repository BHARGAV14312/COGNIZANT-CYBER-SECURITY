// LargeFileReader.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileReader {
    public void readLargeFile(String inputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            System.out.println("Reading file: " + inputFileName);
            while ((line = reader.readLine()) != null) {
                // Process each line (e.g., parse and print sales records)
                processLine(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private void processLine(String line) {
        // Example processing: just print the line
        System.out.println(line);
    }
}
