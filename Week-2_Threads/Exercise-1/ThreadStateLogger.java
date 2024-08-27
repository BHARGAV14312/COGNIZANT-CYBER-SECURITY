// Custom thread class that extends Thread
class CustomThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread is printing: " + i);
                Thread.sleep(500); // Simulate some work with sleep
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
    }
}

// Main class to log thread states
public class ThreadStateLogger {

    public static void main(String[] args) {
        // Create an instance of the custom thread
        CustomThread thread = new CustomThread();
        
        // Log the thread's state before starting
        System.out.println("Thread state before start: " + thread.getState());
        
        // Start the thread
        thread.start();
        
        // Log the thread's state after starting
        System.out.println("Thread state after start: " + thread.getState());
        
        // Continuously log the thread's state until it finishes
        while (thread.isAlive()) {
            System.out.println("Thread state during execution: " + thread.getState());
            try {
                Thread.sleep(100); // Small delay to observe the state transitions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Log the thread's state after completion
        System.out.println("Thread state after completion: " + thread.getState());
    }
}
