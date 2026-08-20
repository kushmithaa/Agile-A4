public class DigitalWallet {

    static double balance = 10000;
    static int transactions = 0;
    static int failedPins = 0;

    static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions++;
        }
    }

    static boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            return false;

        balance -= amount;
        transactions++;
        return true;
    }

    static boolean transfer(double amount) {
        return withdraw(amount);
    }

    static boolean fraud(double amount) {
        return amount > 50000 || transactions > 5 || failedPins >= 3;
    }

    public static void main(String[] args) {

        deposit(5000);
        boolean withdrawal = withdraw(2000);
        boolean transfer = transfer(1000);

        System.out.println("=== DIGITAL WALLET ===");
        System.out.println("Initial Balance: 10000");
        System.out.println("Withdrawal: " +
                (withdrawal ? "SUCCESS" : "FAILED"));
        System.out.println("Transfer: " +
                (transfer ? "SUCCESS" : "FAILED"));
        System.out.printf("Current Balance: %.2f%n", balance);
        System.out.println("Transactions: " + transactions);
        System.out.println("Fraud Check: " +
                (fraud(1000) ? "SUSPICIOUS" : "NORMAL"));
    }
}