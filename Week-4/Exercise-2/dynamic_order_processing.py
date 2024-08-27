# dynamic_order_processing.py

from abc import ABC, abstractmethod

# Step 2: Define the DiscountStrategy interface
class DiscountStrategy(ABC):
    @abstractmethod
    def apply_discount(self, order_amount):
        pass

# Step 3: Implement different discount strategies
class RegularDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        # Regular customers get a 5% discount
        return order_amount * 0.95

class PremiumDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        # Premium customers get a 10% discount
        return order_amount * 0.90

class VIPDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        # VIP customers get a 20% discount
        return order_amount * 0.80

# Step 4: Define the Order class
class Order:
    def __init__(self, customer_type, order_amount):
        self.customer_type = customer_type
        self.order_amount = order_amount
        self.discount_strategy = self._set_discount_strategy()

    def _set_discount_strategy(self):
        if self.customer_type == 'regular':
            return RegularDiscount()
        elif self.customer_type == 'premium':
            return PremiumDiscount()
        elif self.customer_type == 'vip':
            return VIPDiscount()
        else:
            raise ValueError("Unknown customer type")

    # Step 5: Implement the final_price() method
    def final_price(self):
        return self.discount_strategy.apply_discount(self.order_amount)

# Step 6: Create instances of Order and calculate the final price
orders = [
    Order('regular', 100),
    Order('premium', 200),
    Order('vip', 300)
]

# Step 7: Print the final prices
for order in orders:
    print(f"Final price for {order.customer_type.capitalize()} customer: ${order.final_price():.2f}")
