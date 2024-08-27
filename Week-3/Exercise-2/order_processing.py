# Define the variable for the order amount
order_amount = 150

# Define the function to apply a discount
def apply_discount(order_amount):
    if order_amount > 100:
        discount = order_amount * 0.10
        return order_amount - discount
    else:
        return order_amount

# Calculate the final price after applying the discount
final_price = apply_discount(order_amount)

# Print the final price
print(f"The final price after applying the discount is: ${final_price}")
