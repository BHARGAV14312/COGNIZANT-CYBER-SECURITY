import java.util.HashSet;
import java.util.Set;

public class ProductCatalog {
    private Set<String> products;

   
    public ProductCatalog() {
        products = new HashSet<>();
    }

    
    public boolean addProduct(String productName) {
       
        if (products.contains(productName)) {
            System.out.println("Product already exists: " + productName);
            return false; 
        }
        products.add(productName);
        System.out.println("Product added: " + productName);
        return true; 
    }

   
    public boolean removeProduct(String productName) {
        if (products.remove(productName)) {
            System.out.println("Product removed: " + productName);
            return true; 
        }
        System.out.println("Product not found: " + productName);
        return false; 
    }

    
    public boolean searchProduct(String productName) {
        boolean found = products.contains(productName);
        if (found) {
            System.out.println("Product found: " + productName);
        } else {
            System.out.println("Product not found: " + productName);
        }
        return found;
    }

    
    public void displayProducts() {
        System.out.println("Product Catalog:");
        if (products.isEmpty()) {
            System.out.println("No products in the catalog.");
        } else {
            for (String product : products) {
                System.out.println("- " + product);
            }
        }
    }
}
