// LogWriter.java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    public void writeLog(String fileName, String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(logMessage);
            writer.newLine(); // Move to the next line after writing the log message
            System.out.println("Log message has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
