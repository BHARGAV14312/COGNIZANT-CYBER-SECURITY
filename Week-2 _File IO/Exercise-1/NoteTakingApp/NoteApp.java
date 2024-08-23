// NoteApp.java
import java.util.Scanner;

public class NoteApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a note
        System.out.println("Enter a note to save:");
        String note = scanner.nextLine();

        // Specify the file name
        String fileName = "notes.txt";

        // Save the note using FileWriterDemo
        FileWriterDemo fileWriterDemo = new FileWriterDemo();
        fileWriterDemo.saveNoteToFile(fileName, note);

        // Read the note back using FileReaderDemo
        FileReaderDemo fileReaderDemo = new FileReaderDemo();
        fileReaderDemo.readNoteFromFile(fileName);
    }
}
