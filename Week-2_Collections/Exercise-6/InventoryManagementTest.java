// InventoryManagementTest.java
public class InventoryManagementTest {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        Product product1 = new Product(1, "Laptop", 10);
        Product product2 = new Product(2, "Smartphone", 20);
        Product product3 = new Product(3, "Headphones", 15);

        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        inventory.displayProducts();

        inventory.updateProductQuantity(2, 25);

        inventory.removeProduct(3);

        inventory.displayProducts();
    }
}
