public class BookCollectionTest {
    public static void main(String[] args) {
        
        BookCollection myLibrary = new BookCollection();

        
        myLibrary.addBook("The Great Gatsby");
        myLibrary.addBook("To Kill a Mockingbird");
        myLibrary.addBook("1984");
        myLibrary.addBook("The Catcher in the Rye");
        myLibrary.addBook("Moby Dick");

        
        myLibrary.addBook("1984");

       
        myLibrary.displayBooks();

        
        myLibrary.removeBook("1984");

        
        myLibrary.removeBook("The Lord of the Rings");

        myLibrary.displayBooks();
    }
}
