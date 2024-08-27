# enhanced_inventory_management.py

import threading
import time
import json

class Inventory:
    def __init__(self, restock_threshold=10):
        self.items = {}
        self.restock_threshold = restock_threshold

    def add_item(self, item_name, quantity):
        if item_name in self.items:
            self.items[item_name] += quantity
        else:
            self.items[item_name] = quantity

    def remove_item(self, item_name, quantity):
        if item_name in self.items:
            if self.items[item_name] >= quantity:
                self.items[item_name] -= quantity
                if self.items[item_name] == 0:
                    del self.items[item_name]
            else:
                print(f"Not enough {item_name} in stock to remove.")
        else:
            print(f"{item_name} not found in inventory.")

    def check_stock(self):
        low_stock_items = [item for item, quantity in self.items.items() if quantity < self.restock_threshold]
        return low_stock_items

    def save_to_file(self, filename):
        try:
            with open(filename, 'w') as file:
                json.dump(self.items, file)
        except IOError as e:
            print(f"Error saving inventory to file: {e}")

    def load_from_file(self, filename):
        try:
            with open(filename, 'r') as file:
                self.items = json.load(file)
        except IOError as e:
            print(f"Error loading inventory from file: {e}")
        except json.JSONDecodeError as e:
            print(f"Error decoding JSON from file: {e}")

    def start_restock_alerts(self, check_interval=60):
        def alert():
            while True:
                low_stock_items = self.check_stock()
                if low_stock_items:
                    print("Restocking alert! Low stock items:")
                    for item in low_stock_items:
                        print(f"- {item}")
                else:
                    print("All items are sufficiently stocked.")
                time.sleep(check_interval)

        alert_thread = threading.Thread(target=alert, daemon=True)
        alert_thread.start()

# Example usage
if __name__ == "__main__":
    inventory = Inventory()

    # Adding and removing items
    inventory.add_item("Widget", 15)
    inventory.add_item("Gadget", 5)
    inventory.remove_item("Gadget", 3)

    # Start restocking alerts
    inventory.start_restock_alerts(check_interval=10)

    # Save and load inventory state
    inventory.save_to_file("inventory.json")
    inventory.load_from_file("inventory.json")

    # Print the current inventory state
    print("Current inventory state:")
    for item, quantity in inventory.items.items():
        print(f"{item}: {quantity}")

    # Keep the script running to observe alerts
    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        print("Terminating inventory management system.")
