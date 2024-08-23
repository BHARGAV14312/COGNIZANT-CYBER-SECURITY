package EmployeeManagement;

public class EmployeeManagementTest {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();

       
        Employee emp1 = new Employee(1, "John Doe", "123 Main St");
        Employee emp2 = new Employee(2, "Jane Smith", "456 Oak Ave");
        Employee emp3 = new Employee(3, "Alice Johnson", "789 Pine Rd");

        employeeManagement.addEmployee(emp1);
        employeeManagement.addEmployee(emp2);
        employeeManagement.addEmployee(emp3);

        System.out.println("\nDisplaying all employees:");
        employeeManagement.displayEmployees();

        System.out.println("\nUpdating address for employee ID 2:");
        employeeManagement.updateEmployee(2, "New Address 456 Oak Ave");

       
        System.out.println("\nRemoving employee with ID 1:");
        employeeManagement.removeEmployee(1);


        System.out.println("\nDisplaying all employees after update and removal:");
        employeeManagement.displayEmployees();
    }
}
