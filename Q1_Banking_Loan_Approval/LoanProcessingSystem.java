public class LoanProcessingSystem {

    public static void main(String[] args) {

        // Predefined customer details
        String customerId = "C001";
        int age = 30;
        double monthlySalary = 60000;
        double existingLoanAmount = 50000;
        int creditScore = 750;
        String employmentType = "SALARIED";
        double requestedLoanAmount = 500000;
        int loanTenure = 60;

        System.out.println("======================================");
        System.out.println("     BANKING LOAN APPROVAL SYSTEM");
        System.out.println("======================================");

        System.out.println("Customer ID          : " + customerId);
        System.out.println("Age                  : " + age);
        System.out.println("Monthly Salary       : " + monthlySalary);
        System.out.println("Existing Loan Amount : " + existingLoanAmount);
        System.out.println("Credit Score         : " + creditScore);
        System.out.println("Employment Type      : " + employmentType);
        System.out.println("Requested Loan       : " + requestedLoanAmount);
        System.out.println("Loan Tenure          : " + loanTenure + " months");

        // Input validation
        if (age < 18 || age > 65) {
            System.out.println("Status               : REJECTED");
            System.out.println("Reason               : Invalid age");
            return;
        }

        if (monthlySalary <= 0) {
            System.out.println("Status               : REJECTED");
            System.out.println("Reason               : Invalid salary");
            return;
        }

        if (requestedLoanAmount <= 0) {
            System.out.println("Status               : REJECTED");
            System.out.println("Reason               : Invalid loan amount");
            return;
        }

        if (loanTenure <= 0) {
            System.out.println("Status               : REJECTED");
            System.out.println("Reason               : Invalid loan tenure");
            return;
        }

        // Debt-to-income ratio
        double monthlyExistingPayment = existingLoanAmount / 60.0;
        double debtToIncomeRatio =
                (monthlyExistingPayment / monthlySalary) * 100;

        // Eligible loan amount
        double eligibleLoanAmount = monthlySalary * 10;

        // Interest rate based on credit score
        double interestRate;

        if (creditScore >= 750) {
            interestRate = 8.5;
        } else if (creditScore >= 650) {
            interestRate = 10.0;
        } else if (creditScore >= 550) {
            interestRate = 12.0;
        } else {
            interestRate = 15.0;
        }

        // EMI calculation
        double monthlyRate = interestRate / (12 * 100);

        double emi;

        if (monthlyRate == 0) {
            emi = requestedLoanAmount / loanTenure;
        } else {
            emi = (requestedLoanAmount * monthlyRate *
                    Math.pow(1 + monthlyRate, loanTenure))
                    / (Math.pow(1 + monthlyRate, loanTenure) - 1);
        }

        // Approval rules
        boolean approved = true;
        String rejectionReason = "";

        if (creditScore < 600) {
            approved = false;
            rejectionReason = "Poor credit score";
        } else if (debtToIncomeRatio > 50) {
            approved = false;
            rejectionReason = "High debt-to-income ratio";
        } else if (existingLoanAmount > monthlySalary * 5) {
            approved = false;
            rejectionReason = "Existing loan exceeds threshold";
        } else if (requestedLoanAmount > eligibleLoanAmount) {
            approved = false;
            rejectionReason = "Requested amount exceeds eligible amount";
        }

        System.out.println("--------------------------------------");
        System.out.printf("Debt-to-Income Ratio : %.2f%%%n", debtToIncomeRatio);
        System.out.printf("Eligible Loan Amount : %.2f%n", eligibleLoanAmount);
        System.out.printf("Interest Rate        : %.2f%%%n", interestRate);
        System.out.printf("Monthly EMI          : %.2f%n", emi);

        if (approved) {
            System.out.println("Approval Status      : APPROVED");
        } else {
            System.out.println("Approval Status      : REJECTED");
            System.out.println("Reason               : " + rejectionReason);
        }

        System.out.println("======================================");
    }
}