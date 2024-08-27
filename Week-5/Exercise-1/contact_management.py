import pickle

# Functions for text file operations
def read_contacts(filename):
    """Read contacts from a text file."""
    try:
        with open(filename, 'r') as file:
            contacts = file.readlines()
        return [contact.strip() for contact in contacts]
    except FileNotFoundError:
        return []

def write_contacts(filename, contacts):
    """Write contacts to a text file."""
    with open(filename, 'w') as file:
        for contact in contacts:
            file.write(contact + '\n')

def add_contact(filename, contact):
    """Add a new contact to the text file."""
    contacts = read_contacts(filename)
    contacts.append(contact)
    write_contacts(filename, contacts)

def remove_contact(filename, contact):
    """Remove a contact from the text file."""
    contacts = read_contacts(filename)
    if contact in contacts:
        contacts.remove(contact)
        write_contacts(filename, contacts)
    else:
        print(f"Contact '{contact}' not found.")

def display_contacts(filename):
    """Display all contacts from the text file."""
    contacts = read_contacts(filename)
    if contacts:
        print("Contacts List:")
        for contact in contacts:
            print(contact)
    else:
        print("No contacts found.")

# Functions for binary file operations
def save_contacts_binary(filename, contacts):
    """Save contacts to a binary file."""
    with open(filename, 'wb') as file:
        pickle.dump(contacts, file)

def load_contacts_binary(filename):
    """Load contacts from a binary file."""
    try:
        with open(filename, 'rb') as file:
            return pickle.load(file)
    except FileNotFoundError:
        return []

def add_contact_binary(filename, contact):
    """Add a new contact to the binary file."""
    contacts = load_contacts_binary(filename)
    contacts.append(contact)
    save_contacts_binary(filename, contacts)

def remove_contact_binary(filename, contact):
    """Remove a contact from the binary file."""
    contacts = load_contacts_binary(filename)
    if contact in contacts:
        contacts.remove(contact)
        save_contacts_binary(filename, contacts)
    else:
        print(f"Contact '{contact}' not found.")

def display_contacts_binary(filename):
    """Display all contacts from the binary file."""
    contacts = load_contacts_binary(filename)
    if contacts:
        print("Contacts List:")
        for contact in contacts:
            print(contact)
    else:
        print("No contacts found.")

# Main function for user interaction
def main():
    text_filename = 'contacts.txt'
    binary_filename = 'contacts.pkl'
    
    while True:
        print("\n1. Add Contact")
        print("2. Remove Contact")
        print("3. Display Contacts")
        print("4. Exit")
        
        choice = input("Enter choice: ")
        
        if choice == '1':
            contact = input("Enter contact name: ")
            add_contact(text_filename, contact)
            add_contact_binary(binary_filename, contact)
        
        elif choice == '2':
            contact = input("Enter contact name: ")
            remove_contact(text_filename, contact)
            remove_contact_binary(binary_filename, contact)
        
        elif choice == '3':
            print("\nText File Contacts:")
            display_contacts(text_filename)
            print("\nBinary File Contacts:")
            display_contacts_binary(binary_filename)
        
        elif choice == '4':
            break
        
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
