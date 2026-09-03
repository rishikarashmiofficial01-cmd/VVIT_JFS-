// Custom Checked Exception
class InsufficientFundException extends Exception {

    public InsufficientFundException(String message) {
        super(message);
    }
}

// Bank Account class
class BankAccount {

    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Initial Balance: Rs." + balance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;

        System.out.println(
                "Deposited: Rs." + amount +
                        " | Current Balance: Rs." + balance);
    }

    // Withdraw method with checked exception
    public void withdraw(double amount)
            throws InsufficientFundException {

        if (amount > balance) {
            throw new InsufficientFundException(
                    "Insufficient funds! Available Balance: Rs." + balance);
        }

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
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

        BankAccount account = new BankAccount("ACC-9001", 500.0);

        account.displayAccountDetails();

        System.out.println();

        // Successful withdrawal
        try {

            account.withdraw(200.0);

        } catch (InsufficientFundException e) {

            System.out.println(
                    "Exception: " + e.getMessage());
        }

        System.out.println();

        // Withdrawal causing exception
        try {

            account.withdraw(400.0);

        } catch (InsufficientFundException e) {

            System.out.println(
                    "Exception: " + e.getMessage());
        }

        System.out.println();

        // Deposit
        account.deposit(300.0);

        System.out.println();

        // Try withdrawal again
        try {

            account.withdraw(500.0);

        } catch (InsufficientFundException e) {

            System.out.println(
                    "Exception: " + e.getMessage());
        }
    }
}