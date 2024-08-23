// FileProcessorApp.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LargeFileReader fileReader = new LargeFileReader();
        LargeFileWriter fileWriter = new LargeFileWriter();

        // Define file names
        String inputFileName = "sales_data.txt";
        String outputFileName = "processed_sales_data.txt";

        // Read and process large file
        System.out.println("Processing file: " + inputFileName);
        List<String> processedData = new ArrayList<>();
        fileReader.readLargeFile(inputFileName);

        // Example processing: simulate some processed data
        processedData.add("Processed Record 1");
        processedData.add("Processed Record 2");

        // Write processed data to a new file
        System.out.println("Writing processed data to: " + outputFileName);
        fileWriter.writeProcessedData(outputFileName, processedData);

        // Demonstrate error handling by attempting to read/write from/to non-existent files
        System.out.println("\nAttempting to read from a non-existent file:");
        fileReader.readLargeFile("non_existent_file.txt");

        System.out.println("\nAttempting to write to a restricted directory:");
        fileWriter.writeProcessedData("/restricted_directory/processed_sales_data.txt", processedData);
    }
}
