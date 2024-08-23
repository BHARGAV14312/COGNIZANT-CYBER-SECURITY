package EmployeeManagement;

public class Employee {
    private int id;
    private String name;
    private String address;

    // Constructor
    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Override toString method for easy display
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Address: " + address;
    }
}
