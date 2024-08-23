import java.util.LinkedHashSet;

public class BookCollection {
    private LinkedHashSet<String> books;

    
    public BookCollection() {
        books = new LinkedHashSet<>();
    }

    
    public void addBook(String bookTitle) {
        if (books.add(bookTitle)) {
            System.out.println("Book added: " + bookTitle);
        } else {
            System.out.println("Book already exists in the collection: " + bookTitle);
        }
    }

    
    public void removeBook(String bookTitle) {
        if (books.remove(bookTitle)) {
            System.out.println("Book removed: " + bookTitle);
        } else {
            System.out.println("Book not found in the collection: " + bookTitle);
        }
    }

    public void displayBooks() {
        System.out.println("Books in the collection:");
        for (String book : books) {
            System.out.println(book);
        }
    }
}
