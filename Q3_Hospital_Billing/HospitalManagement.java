public class HospitalManagement {

    static void bill(String patient, int age, boolean emergency,
                     boolean insurance, boolean followUp,
                     double lab, double medicine) {

        double consultation = emergency ? 1000 : 500;

        if (age >= 60)
            consultation *= 0.8;

        if (followUp)
            consultation *= 0.5;

        double total = consultation + lab + medicine;
        double coverage = insurance ? total * 0.70 : 0;
        double payable = total - coverage;

        System.out.println("=== HOSPITAL BILLING ===");
        System.out.println("Patient: " + patient);
        System.out.printf("Consultation: %.2f%n", consultation);
        System.out.printf("Lab Charges: %.2f%n", lab);
        System.out.printf("Medicine: %.2f%n", medicine);
        System.out.printf("Insurance: %.2f%n", coverage);
        System.out.printf("Patient Payable: %.2f%n", payable);
    }

    public static void main(String[] args) {
        bill("P001", 35, false, true,
             false, 1000, 1500);
    }
}