// ContactApp.java
import java.util.Scanner;

public class ContactApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactWriter contactWriter = new ContactWriter();
        ContactReader contactReader = new ContactReader();

        // Create a contact object
        System.out.println("Enter contact details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);

        // Define the file name
        String fileName = "contact.ser";

        // Save the contact
        contactWriter.saveContact(fileName, contact);

        // Read and display the contact
        System.out.println("\nReading the contact from the file:");
        contactReader.readContact(fileName);

        // Demonstrate error handling by attempting to read from a non-existent file
        System.out.println("\nAttempting to read from a non-existent file:");
        contactReader.readContact("non_existent_file.ser");
    }
}
