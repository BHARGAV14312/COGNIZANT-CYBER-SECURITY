// Task class simulating a task with sleep, yield, and join
class Task extends Thread {
    private String taskName;
    private Thread dependentTask;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public void setDependentTask(Thread dependentTask) {
        this.dependentTask = dependentTask;
    }

    @Override
    public void run() {
        try {
            System.out.println(taskName + " is starting.");

            // If there is a dependent task, wait for it to complete
            if (dependentTask != null) {
                System.out.println(taskName + " is waiting for " + dependentTask.getName() + " to complete.");
                dependentTask.join();
            }

            // Perform a sequence of operations
            for (int i = 1; i <= 3; i++) {
                System.out.println(taskName + " is performing operation " + i);
                
                // Sleep to simulate time-consuming work
                Thread.sleep(1000);
                
                // Yield to allow other threads to execute
                System.out.println(taskName + " is yielding.");
                Thread.yield();
            }

            System.out.println(taskName + " has finished.");
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted.");
        }
    }
}

// Main class to simulate the task scheduler
public class TaskScheduler {

    public static void main(String[] args) {
        // Create task threads
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");

        // Set task dependencies
        task3.setDependentTask(task2);

        // Start the tasks
        task1.start();
        task2.start();
        task3.start();

        // Main thread waits for all tasks to complete
        try {
            task1.join();
            task2.join();
            task3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("All tasks have completed. Main thread exiting.");
    }
}
