public class OrderTrackingTest {
    public static void main(String[] args) {
        // Create an instance of OrderTracking
        OrderTracking orderTracking = new OrderTracking();

        // Add orders
        orderTracking.addOrder(new Order(1, "Pizza Margherita"));
        orderTracking.addOrder(new Order(2, "Spaghetti Carbonara"));
        orderTracking.addOrder(new Order(3, "Caesar Salad"));

      
        orderTracking.displayOrders();

        orderTracking.processOrder();

      
        orderTracking.displayOrders();

        orderTracking.processOrder();

        orderTracking.displayOrders();

  
        orderTracking.processOrder();

        orderTracking.processOrder();
    }
}
