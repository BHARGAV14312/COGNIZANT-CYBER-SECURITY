import java.util.LinkedList;

public class OrderTracking {
    private LinkedList<Order> orders;

    
    public OrderTracking() {
        orders = new LinkedList<>();
    }

    
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Added: " + order);
    }

    
    public Order processOrder() {
        if (orders.isEmpty()) {
            System.out.println("No orders to process.");
            return null;
        }
        Order processedOrder = orders.removeFirst();
        System.out.println("Processed: " + processedOrder);
        return processedOrder;
    }

    
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }
        System.out.println("Current Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
