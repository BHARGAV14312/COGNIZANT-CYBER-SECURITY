import logging
from datetime import datetime

# Set up logging configuration
logging.basicConfig(filename='error_log.txt', level=logging.ERROR, format='%(asctime)s - %(levelname)s - %(message)s')

def process_transaction(amount, filename):
    try:
        # Simulate file operation (e.g., reading transaction data)
        with open(filename, 'r') as file:
            data = file.read()
        
        # Simulate transaction processing
        if amount <= 0:
            raise ValueError("Transaction amount must be positive.")
        
        print(f"Processing transaction of ${amount}...")

    except FileNotFoundError as e:
        log_error(f"FileNotFoundError: {e}")
        print("Error: The file was not found. Please check the file path and try again.")
    
    except ValueError as e:
        log_error(f"ValueError: {e}")
        print("Error: Invalid transaction amount. Please enter a positive value.")
    
    except Exception as e:
        log_error(f"Unexpected error: {e}")
        print("An unexpected error occurred. Please try again later.")

def log_error(message):
    logging.error(message)

def validate_transaction(amount, filename):
    if not isinstance(amount, (int, float)):
        raise ValueError("Amount must be a number.")
    if amount <= 0:
        raise ValueError("Amount must be greater than zero.")
    
    try:
        with open(filename, 'r') as file:
            pass
    except FileNotFoundError:
        raise FileNotFoundError("The file was not found. Please check the file path.")

# Example usage:
if __name__ == "__main__":
    try:
        amount = float(input("Enter transaction amount: "))
        filename = input("Enter filename: ")
        validate_transaction(amount, filename)
        process_transaction(amount, filename)
    except ValueError as e:
        log_error(f"Validation error: {e}")
        print(f"Validation error: {e}")
    except Exception as e:
        log_error(f"Unexpected error during validation: {e}")
        print("An unexpected error occurred during validation.")
