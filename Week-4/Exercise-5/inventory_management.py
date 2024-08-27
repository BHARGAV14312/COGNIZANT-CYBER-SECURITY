# inventory_management.py

# Lists
product_names = []

def add_product(name):
    """Add a product to the list."""
    if name not in product_names:
        product_names.append(name)
    else:
        print(f"Product {name} already exists.")

def remove_product(name):
    """Remove a product from the list."""
    if name in product_names:
        product_names.remove(name)
    else:
        print(f"Product {name} not found.")

def update_product(old_name, new_name):
    """Update a product name in the list."""
    if old_name in product_names:
        index = product_names.index(old_name)
        product_names[index] = new_name
    else:
        print(f"Product {old_name} not found.")

# Dictionaries
product_details = {}

def add_product_details(name, quantity, price):
    """Add product details to the dictionary."""
    if name not in product_details:
        product_details[name] = {'quantity': quantity, 'price': price}
    else:
        print(f"Product details for {name} already exist.")

def update_product_details(name, quantity=None, price=None):
    """Update product details."""
    if name in product_details:
        if quantity is not None:
            product_details[name]['quantity'] = quantity
        if price is not None:
            product_details[name]['price'] = price
    else:
        print(f"Product {name} not found.")

def delete_product_details(name):
    """Delete product details from the dictionary."""
    if name in product_details:
        del product_details[name]
    else:
        print(f"Product {name} not found.")

# Tuples
product_catalog = {
    '123': ('Widget', 10, 19.99),
    '456': ('Gadget', 5, 29.99),
    '789': ('Doodad', 20, 9.99)
}

def display_catalog():
    """Display the product catalog."""
    for code, (name, quantity, price) in product_catalog.items():
        print(f"Code: {code}, Name: {name}, Quantity: {quantity}, Price: {price}")

# Sets
categories = set()

def add_category(category):
    """Add a category to the set."""
    categories.add(category)

def remove_category(category):
    """Remove a category from the set."""
    categories.discard(category)  # Using discard to avoid KeyError if category not found

# Combining Collections
def generate_price_report():
    """Generate a report of products sorted by price."""
    sorted_products = sorted(product_details.items(), key=lambda x: x[1]['price'])
    for name, details in sorted_products:
        print(f"Product: {name}, Quantity: {details['quantity']}, Price: {details['price']}")

def find_products_in_price_range(min_price, max_price):
    """Find products within a certain price range."""
    products_in_range = {name for name, details in product_details.items()
                         if min_price <= details['price'] <= max_price}
    return products_in_range

# Example usage
if __name__ == "__main__":
    # List operations
    add_product("Widget")
    add_product("Gadget")
    update_product("Gadget", "GadgetPro")
    remove_product("Widget")
    
    # Dictionary operations
    add_product_details("GadgetPro", 5, 29.99)
    update_product_details("GadgetPro", price=25.99)
    delete_product_details("GadgetPro")
    
    # Tuples
    display_catalog()
    
    # Set operations
    add_category("Electronics")
    add_category("Tools")
    remove_category("Tools")
    
    # Combining collections
    generate_price_report()
    products_in_range = find_products_in_price_range(10, 30)
    print("Products in price range 10-30:", products_in_range)
