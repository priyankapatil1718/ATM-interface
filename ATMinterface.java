import java.util.*;

class ATM {
    private double balance;
    private List<String> transactionHistory;
    private String userPIN;

    public ATM(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.userPIN = pin;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePIN(String enteredPIN) {
        return userPIN.equals(enteredPIN);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
        System.out.println("Deposit successful!");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful!");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String txn : transactionHistory) {
            System.out.println(txn);
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM userATM = new ATM(1000.0, "1234"); // Initial balance, PIN set to "1234"

        System.out.print("Enter your PIN: ");
        String enteredPIN = scanner.next();

        if (!userATM.validatePIN(enteredPIN)) {
            System.out.println("Incorrect PIN! Access Denied.");
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    userATM.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    userATM.withdraw(withdrawAmount);
                    break;
                case 3:
                    userATM.showBalance();
                    break;
                case 4:
                    userATM.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}