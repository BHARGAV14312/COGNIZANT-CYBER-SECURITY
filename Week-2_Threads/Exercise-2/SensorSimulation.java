import java.util.Random;

// Sensor class simulating data collection
class Sensor extends Thread {
    private String sensorName;
    private Random random = new Random();

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                int data = random.nextInt(100); // Simulate data collection
                System.out.println(sensorName + " collected data: " + data);
                Thread.sleep(1000); // Simulate time delay between data collections
            }
        } catch (InterruptedException e) {
            System.out.println(sensorName + " was interrupted.");
        }
        System.out.println(sensorName + " has finished data collection.");
    }
}

// Main class to simulate the sensors
public class SensorSimulation {

    public static void main(String[] args) {
        // Create and start multiple Sensor threads
        Sensor sensor1 = new Sensor("Sensor 1");
        Sensor sensor2 = new Sensor("Sensor 2");
        Sensor sensor3 = new Sensor("Sensor 3");

        sensor1.start();
        sensor2.start();
        sensor3.start();

        // Main thread waits for all sensor threads to complete
        try {
            sensor1.join();
            sensor2.join();
            sensor3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("All sensors have completed data collection. Main thread exiting.");
    }
}
