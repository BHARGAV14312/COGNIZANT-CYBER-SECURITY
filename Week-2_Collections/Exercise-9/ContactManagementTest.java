public class ContactManagementTest {
    public static void main(String[] args) {
        ContactManagement cm = new ContactManagement();

        Contact contact1 = new Contact(1, "Alice", "123-456-7890");
        Contact contact2 = new Contact(2, "Bob", "234-567-8901");
        Contact contact3 = new Contact(3, "Charlie", "345-678-9012");

       
        cm.addContact(contact1);
        cm.addContact(contact2);
        cm.addContact(contact3);

        System.out.println("All Contacts:");
        cm.displayContacts();

        cm.removeContact(2);

        System.out.println("\nContacts after removal:");
        cm.displayContacts();
    }
}
