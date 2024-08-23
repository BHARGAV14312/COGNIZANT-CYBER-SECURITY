// LargeFileWriter.java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LargeFileWriter {
    public void writeProcessedData(String outputFileName, List<String> processedData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            System.out.println("Writing data to file: " + outputFileName);
            for (String data : processedData) {
                writer.write(data);
                writer.newLine(); // Move to the next line after writing each record
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
