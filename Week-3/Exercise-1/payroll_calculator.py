# Define the variables
hours_worked = 40
hourly_rate = 15

# Define the function to calculate total pay
def calculate_pay(hours, rate):
    return hours * rate

# Calculate pay using the function
total_pay = calculate_pay(hours_worked, hourly_rate)

# Print the total pay
print(f"The total pay for the employee is: ${total_pay}")
