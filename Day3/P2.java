package Day3;

// Custom checked exception
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {

    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: Rs." + balance);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(
                    "Deposited: Rs." + amount +
                            " | New Balance: Rs." + balance);
        }
    }

    // Method to withdraw money
    // 'throws' declares the checked exception
    public void withdraw(double amount) throws InsufficientFundsException {

        if (amount > balance) {

            double deficit = amount - balance;

            // 'throw' explicitly creates and raises an exception
            throw new InsufficientFundsException(
                    "Withdrawal Failed: Overdraft limit reached. " +
                            "Insufficient funds by Rs." + deficit);
        }

        balance -= amount;

        System.out.println(
                "Withdrawn: Rs." + amount +
                        " | Remaining Balance: Rs." + balance);
    }
}

// Main class
public class P2 {

    public static void main(String[] args) {

        // --- 1. Handling Custom Checked Exception ---
        System.out.println(
                "--- 1. Checked Custom Exception Handling ---");

        BankAccount account = new BankAccount(
                "ACC-9001",
                500.0);

        account.displayAccountDetails();

        try {

            System.out.println(
                    "Attempting withdrawal of Rs.650...");

            account.withdraw(650.0);

        } catch (InsufficientFundsException e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }

        // --- 2. Successful Withdrawal ---
        System.out.println(
                "\n--- 2. Successful Withdrawal ---");

        try {

            System.out.println(
                    "Attempting withdrawal of Rs.200...");

            account.withdraw(200.0);

        } catch (InsufficientFundsException e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }

        // --- 3. Deposit ---
        System.out.println(
                "\n--- 3. Deposit Operation ---");

        account.deposit(1000.0);

        account.displayAccountDetails();

        // --- 4. Another Withdrawal ---
        System.out.println(
                "\n--- 4. Another Withdrawal ---");

        try {

            System.out.println(
                    "Attempting withdrawal of Rs.1000...");

            account.withdraw(1000.0);

        } catch (InsufficientFundsException e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }

        // --- 5. Final Account Details ---
        System.out.println(
                "\n--- 5. Final Account Details ---");

        account.displayAccountDetails();
    }
}