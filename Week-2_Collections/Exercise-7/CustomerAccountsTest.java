public class CustomerAccountsTest {
    public static void main(String[] args) {
        CustomerAccounts customerAccounts = new CustomerAccounts();

        Customer customer1 = new Customer(1, "Alice Johnson", "alice.johnson@example.com");
        Customer customer2 = new Customer(2, "Bob Smith", "bob.smith@example.com");
        Customer customer3 = new Customer(3, "Charlie Brown", "charlie.brown@example.com");

        customerAccounts.addCustomer(customer1);
        customerAccounts.addCustomer(customer2);
        customerAccounts.addCustomer(customer3);

        System.out.println("All customers:");
        customerAccounts.displayCustomers();

        customerAccounts.removeCustomer(2);

        System.out.println("\nAfter removing customer with ID 2:");
        customerAccounts.displayCustomers();
    }
}
