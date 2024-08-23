import java.util.TreeSet;

public class UserRegistration {
    private TreeSet<String> users;

    
    public UserRegistration() {
        users = new TreeSet<>();
    }

    
    public void registerUser(String userName) {
        if (users.add(userName)) {
            System.out.println(userName + " has been registered.");
        } else {
            System.out.println(userName + " is already registered.");
        }
    }

    
    public void removeUser(String userName) {
        if (users.remove(userName)) {
            System.out.println(userName + " has been removed.");
        } else {
            System.out.println(userName + " was not found in the registration list.");
        }
    }

    
    public void displayUsers() {
        System.out.println("Registered Users (Alphabetical Order):");
        for (String user : users) {
            System.out.println(user);
        }
    }
}
