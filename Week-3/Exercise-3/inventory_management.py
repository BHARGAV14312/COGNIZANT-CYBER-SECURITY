# Define a list of items with their quantities
inventory = [('item1', 10), ('item2', 0), ('item3', 5)]

# Define the function to check inventory
def check_inventory(inventory):
    for item, quantity in inventory:
        if quantity == 0:
            print(f"Alert: {item} is out of stock.")

# Check the inventory
check_inventory(inventory)
