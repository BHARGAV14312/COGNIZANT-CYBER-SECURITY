import java.util.Hashtable;

public class ContactManagement {
    private Hashtable<Integer, Contact> contacts;

    // Constructor
    public ContactManagement() {
        this.contacts = new Hashtable<>();
    }

    public synchronized void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    public synchronized void removeContact(int contactId) {
        contacts.remove(contactId);
    }

    public synchronized void displayContacts() {
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }
}
