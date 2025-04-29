import java.util.*;

public class ATMInterface {
    private static double balance = 1000.0;
    private static String userId = "userA";
    private static String pin = "4321";
    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Welcome to the ATM ");
        System.out.print("Enter User ID: ");
        String inputId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (inputId.equals(userId) && inputPin.equals(pin)) {
            System.out.println("Login successful!");

            int choice;
            do {
                System.out.println("\n1. Transaction History");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> showHistory();
                    case 2 -> {
                        System.out.print("Enter deposit amount: ");
                        double amt = sc.nextDouble();
                        deposit(amt);
                    }
                    case 3 -> {
                        System.out.print("Enter withdraw amount: ");
                        double amt = sc.nextDouble();
                        withdraw(amt);
                    }
                    case 4 -> {
                        System.out.print("Enter transfer amount: ");
                        double amt = sc.nextDouble();
                        transfer(amt);
                    }
                    case 5 -> System.out.println("Thank you for using ATM.");
                    default -> System.out.println("Invalid option.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid Number.");
        }

        sc.close();
    }

    static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String h : history) System.out.println(h);
        }
    }

    static void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            history.add("Deposited $" + amt);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    static void withdraw(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            history.add("Withdrew $" + amt);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    static void transfer(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            history.add("Transferred $" + amt + " to another user");
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
