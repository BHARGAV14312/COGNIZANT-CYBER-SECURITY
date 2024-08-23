// LogApp.java
import java.util.Scanner;

public class LogApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LogWriter logWriter = new LogWriter();
        LogReader logReader = new LogReader();
        
        // Define the log file name
        String fileName = "application.log";

        // Write multiple log messages
        System.out.println("Enter log messages (type 'exit' to finish):");
        while (true) {
            String logMessage = scanner.nextLine();
            if ("exit".equalsIgnoreCase(logMessage)) {
                break;
            }
            logWriter.writeLog(fileName, logMessage);
        }

        // Read and display the logs
        System.out.println("\nDisplaying logs from the file:");
        logReader.readLogs(fileName);
        
        // Demonstrate error handling by attempting to read from a non-existent file
        System.out.println("\nAttempting to read from a non-existent file:");
        logReader.readLogs("non_existent_file.log");
    }
}
