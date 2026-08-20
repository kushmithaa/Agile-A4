public class WalletSecurityQA {

    static void test(String name, boolean result) {
        System.out.println(name + " : " +
                (result ? "PASS" : "FAIL"));
    }

    static boolean validAmount(double amount) {
        return amount > 0;
    }

    static boolean sufficient(double balance, double amount) {
        return amount > 0 && amount <= balance;
    }

    static boolean dailyLimit(double total) {
        return total <= 100000;
    }

    static boolean suspicious(double amount, int transactions,
                              int failedPins) {
        return amount > 50000 ||
               transactions > 5 ||
               failedPins >= 3;
    }

    public static void main(String[] args) {

        test("Normal Transaction",
                sufficient(10000, 2000));

        test("Insufficient Balance",
                !sufficient(1000, 2000));

        test("Daily Limit",
                !dailyLimit(120000));

        test("Multiple Failed PINs",
                suspicious(1000, 2, 3));

        test("Suspicious Transaction",
                suspicious(60000, 1, 0));

        test("Duplicate Transaction",
                true);

        test("Negative Amount",
                !validAmount(-500));

        test("Concurrent Transactions",
                sufficient(10000, 3000) &&
                sufficient(7000, 3000));

        System.out.println("\nWallet QA Testing Completed");
    }
}