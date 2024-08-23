public class UserRegistrationTest {
    public static void main(String[] args) {
        
        UserRegistration userReg = new UserRegistration();

        
        userReg.registerUser("Alice");
        userReg.registerUser("Bob");
        userReg.registerUser("Charlie");
        userReg.registerUser("David");

     
        userReg.displayUsers();

   
        userReg.registerUser("Alice");

     
        userReg.removeUser("Bob");

       
        userReg.displayUsers();

     
        userReg.removeUser("Eve");

        
        userReg.registerUser("Eve");
        userReg.registerUser("Frank");

        userReg.displayUsers();
    }
}
