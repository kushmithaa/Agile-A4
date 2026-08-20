public class LoanProcessingQA {

    static void test(String name, boolean result) {
        System.out.println(name + " : " +
                (result ? "PASS" : "FAIL"));
    }

    static boolean validLoan(int age, double salary, int credit) {
        return age >= 18 && age <= 65 &&
               salary > 0 && credit >= 600;
    }

    public static void main(String[] args) {

        test("Minimum Age", validLoan(18, 30000, 700));
        test("Maximum Age", validLoan(65, 30000, 700));
        test("Invalid Salary", !validLoan(30, -5000, 700));
        test("Poor Credit Score", !validLoan(30, 30000, 500));
        test("Valid Customer", validLoan(30, 60000, 750));
        test("Self Employed", validLoan(35, 50000, 700));

        System.out.println("QA Testing Completed");
    }
}