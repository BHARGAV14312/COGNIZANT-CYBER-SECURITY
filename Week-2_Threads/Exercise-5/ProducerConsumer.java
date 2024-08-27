import java.util.LinkedList;
import java.util.Queue;

// Shared resource class that holds the data queue
class DataQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public DataQueue(int capacity) {
        this.capacity = capacity;
    }

    // Method for adding data to the queue (called by Producer)
    public synchronized void produce(int data) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Queue is full. Producer is waiting.");
            wait();
        }
        queue.add(data);
        System.out.println("Produced: " + data);
        notifyAll(); // Notify consumers that data is available
    }

    // Method for removing data from the queue (called by Consumer)
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Consumer is waiting.");
            wait();
        }
        int data = queue.poll();
        System.out.println("Consumed: " + data);
        notifyAll(); // Notify producers that space is available
        return data;
    }
}

// Producer thread class
class Producer extends Thread {
    private DataQueue dataQueue;

    public Producer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        int data = 0;
        try {
            while (true) {
                dataQueue.produce(data++);
                Thread.sleep(1000); // Simulate time taken to produce data
            }
        } catch (InterruptedException e) {
            System.out.println("Producer was interrupted.");
        }
    }
}

// Consumer thread class
class Consumer extends Thread {
    private DataQueue dataQueue;

    public Consumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                dataQueue.consume();
                Thread.sleep(1500); // Simulate time taken to consume data
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer was interrupted.");
        }
    }
}

// Main class to simulate the producer-consumer system
public class ProducerConsumer {

    public static void main(String[] args) {
        // Shared DataQueue with a capacity of 5
        DataQueue dataQueue = new DataQueue(5);

        // Create and start multiple Producer and Consumer threads
        Producer producer1 = new Producer(dataQueue);
        Producer producer2 = new Producer(dataQueue);
        Consumer consumer1 = new Consumer(dataQueue);
        Consumer consumer2 = new Consumer(dataQueue);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        // Let the simulation run for a while, then stop
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        producer1.interrupt();
        producer2.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
    }
}
