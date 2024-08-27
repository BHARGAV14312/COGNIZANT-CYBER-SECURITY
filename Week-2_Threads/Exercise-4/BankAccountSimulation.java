// BankAccount class with synchronized methods for deposit and withdrawal
class BankAccount {
    private int balance = 0;

    // Synchronized method for deposit
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Current balance: " + balance);
    }

    // Synchronized method for withdrawal
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Current balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds. Current balance: " + balance);
        }
    }

    // Getter for balance (no need to synchronize since it only reads the value)
    public int getBalance() {
        return balance;
    }
}

// Transaction class performing deposit and withdrawal operations
class Transaction extends Thread {
    private BankAccount account;
    private int depositAmount;
    private int withdrawalAmount;

    public Transaction(BankAccount account, int depositAmount, int withdrawalAmount) {
        this.account = account;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        account.deposit(depositAmount);
        account.withdraw(withdrawalAmount);
    }
}

// Main class to test synchronization
public class BankAccountSimulation {

    public static void main(String[] args) {
        // Shared BankAccount instance
        BankAccount account = new BankAccount();

        // Create and start multiple Transaction threads
        Transaction transaction1 = new Transaction(account, 100, 50);
        Transaction transaction2 = new Transaction(account, 200, 150);
        Transaction transaction3 = new Transaction(account, 50, 30);

        transaction1.start();
        transaction2.start();
        transaction3.start();

        // Wait for all transactions to complete
        try {
            transaction1.join();
            transaction2.join();
            transaction3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}
