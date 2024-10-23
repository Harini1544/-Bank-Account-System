import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative.");
            this.balance = 0;
        }
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank Account System!");

        // Ask for the user's name and initial deposit
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double initialBalance = scanner.nextDouble();

        // Create a new bank account
        BankAccount account = new BankAccount(name, initialBalance);

        // Menu system for user interaction
        int choice;
        do {
            System.out.println("\n--- Bank Account Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the Bank Account System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
