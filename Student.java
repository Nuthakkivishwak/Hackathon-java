import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;

    // Parameterized constructor to initialize all account details
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to add the given amount to the balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money only if sufficient balance is available
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Method to return the current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details and balance
    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

public class Main {
    // Separate method for deposit operation
    public static void performDeposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    // Separate method for withdrawal operation
    public static void performWithdrawal(BankAccount account, double amount) {
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Checking if input exists to prevent sandbox timeout/blocking errors
        if (scanner.hasNextLine()) {
            String accNum = scanner.nextLine();
            String name = scanner.nextLine();
            double initBalance = scanner.nextDouble();

            // Create object using parameterized constructor
            BankAccount myAccount = new BankAccount(accNum, name, initBalance);

            if (scanner.hasNextDouble()) {
                double depositAmount = scanner.nextDouble();
                performDeposit(myAccount, depositAmount);
            }

            if (scanner.hasNextDouble()) {
                double withdrawalAmount = scanner.nextDouble();
                performWithdrawal(myAccount, withdrawalAmount);
            }

            // Display final account details
            myAccount.displayAccount();
        }

        scanner.close();
    }
}