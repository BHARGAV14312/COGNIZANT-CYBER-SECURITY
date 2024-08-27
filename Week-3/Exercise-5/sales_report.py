# Define a list of sales amounts
sales = [200, 600, 150, 800, 300]

# Define the function to generate the report
def generate_report(sales):
    total_sales = 0
    print("Sales Report for the Previous Month:")
    for amount in sales:
        total_sales += amount
        if amount > 500:
            print(f"High Sale: ${amount}")
        else:
            print(f"Sale: ${amount}")
    
    return total_sales

# Generate the report and calculate the total sales
total_sales = generate_report(sales)

# Print the total sales for the month
print(f"\nTotal sales for the month: ${total_sales}")
