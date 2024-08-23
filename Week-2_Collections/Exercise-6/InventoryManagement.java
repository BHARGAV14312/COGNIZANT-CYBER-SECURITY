// InventoryManagement.java
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    private Map<Integer, Product> products;

    public InventoryManagement() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (!products.containsKey(product.getId())) {
            products.put(product.getId(), product);
            System.out.println("Product added: " + product);
        } else {
            System.out.println("Product ID already exists: " + product.getId());
        }
    }

    public void removeProduct(int productId) {
        if (products.containsKey(productId)) {
            Product removedProduct = products.remove(productId);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product ID not found: " + productId);
        }
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Product quantity updated: " + product);
        } else {
            System.out.println("Product ID not found: " + productId);
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("Products in inventory:");
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}
