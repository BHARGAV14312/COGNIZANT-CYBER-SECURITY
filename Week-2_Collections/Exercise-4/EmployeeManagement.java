package EmployeeManagement;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private List<Employee> employees;

    
    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

   
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Added: " + employee);
    }

 
    public boolean removeEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                System.out.println("Removed: " + employee);
                return true;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
        return false;
    }

    public boolean updateEmployee(int employeeId, String newAddress) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employee.setAddress(newAddress);
                System.out.println("Updated: " + employee);
                return true;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
        return false;
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
