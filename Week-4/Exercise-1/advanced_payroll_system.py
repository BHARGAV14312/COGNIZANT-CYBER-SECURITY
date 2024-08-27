# advanced_payroll_system.py

class Employee:
    def __init__(self, name, hours_worked, hourly_rate):
        self.name = name
        self.hours_worked = hours_worked
        self.hourly_rate = hourly_rate
    
    def calculate_pay(self):
        # Define standard and overtime hours
        standard_hours = min(self.hours_worked, 40)
        overtime_hours = max(self.hours_worked - 40, 0)
        
        # Calculate pay
        standard_pay = standard_hours * self.hourly_rate
        overtime_pay = overtime_hours * self.hourly_rate * 1.5
        
        return standard_pay + overtime_pay

class Manager(Employee):
    def __init__(self, name, hours_worked, hourly_rate, bonus):
        super().__init__(name, hours_worked, hourly_rate)
        self.bonus = bonus
    
    def calculate_pay(self):
        base_pay = super().calculate_pay()
        return base_pay + self.bonus

# Instantiate objects and calculate pay
employee = Employee(name="John Doe", hours_worked=45, hourly_rate=20)
manager = Manager(name="Jane Smith", hours_worked=50, hourly_rate=30, bonus=500)

# Print total pay
print(f"Total pay for {employee.name}: ${employee.calculate_pay():.2f}")
print(f"Total pay for {manager.name}: ${manager.calculate_pay():.2f}")
