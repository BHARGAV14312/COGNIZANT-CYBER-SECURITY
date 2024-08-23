public class ProductCatalogTest {
    public static void main(String[] args) {
       
        ProductCatalog catalog = new ProductCatalog();

        
        catalog.addProduct("Laptop");
        catalog.addProduct("Smartphone");
        catalog.addProduct("Tablet");

        
        catalog.addProduct("Laptop");

        
        catalog.displayProducts();

        
        catalog.searchProduct("Smartphone");
        catalog.searchProduct("Camera");

        
        catalog.removeProduct("Tablet");

        
        catalog.removeProduct("Camera");

        catalog.displayProducts();
    }
}
