import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    // Account information
    private String accountNumber;
    private int pin;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public ATM(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to display main menu
    public void displayMenu() {
        System.out.println("Welcome to ATM Machine");
        System.out.println("1. Account Balance Inquiry");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Cash Deposit");
        System.out.println("4. PIN Change");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to authenticate PIN
    public boolean authenticatePIN(int pin) {
        return this.pin == pin;
    }

    // Method to display account balance
    public void displayBalance() {
        System.out.println("Your account balance is: $" + balance);
    }

    // Method to withdraw cash
    public void withdrawCash(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawal of $" + amount);
            System.out.println("Withdrawal successful. New balance is: $" + balance);
        }
    }

    // Method to deposit cash
    public void depositCash(double amount) {
        balance += amount;
        transactionHistory.add("Deposit of $" + amount);
        System.out.println("Deposit successful. New balance is: $" + balance);
    }

    // Method to change PIN
    public void changePIN(int newPIN) {
        pin = newPIN;
        System.out.println("PIN changed successfully");
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Main method
    public static void main(String[] args) {
        ATM atm = new ATM("9834310322", 1722, 100000.0);

        Scanner scanner = new Scanner(System.in);
        int choice;
        int pin;

        while (true) {
            System.out.print("Enter your PIN: ");
            pin = scanner.nextInt();

            if (atm.authenticatePIN(pin)) {
                while (true) {
                    atm.displayMenu();
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            atm.displayBalance();
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            atm.withdrawCash(amount);
                            break;
                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            amount = scanner.nextDouble();
                            atm.depositCash(amount);
                            break;
                        case 4:
                            System.out.print("Enter new PIN: ");
                            int newPIN = scanner.nextInt();
                            atm.changePIN(newPIN);
                            break;
                        case 5:
                            atm.displayTransactionHistory();
                            break;
                        case 6:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            } else {
                System.out.println("Invalid PIN");
            }
        }
    }
}
