public class HospitalManagementQA {

    static void test(String name, boolean result) {
        System.out.println(name + " : " +
                (result ? "PASS" : "FAIL"));
    }

    static double bill(int age, boolean emergency,
                       boolean insurance, boolean followUp,
                       double lab, double medicine) {

        double consultation = emergency ? 1000 : 500;

        if (age >= 60)
            consultation *= 0.8;

        if (followUp)
            consultation *= 0.5;

        double total = consultation + lab + medicine;
        double coverage = insurance ? total * 0.70 : 0;

        return total - coverage;
    }

    public static void main(String[] args) {

        test("Normal Patient",
                bill(35, false, false, false, 1000, 1500) == 3000);

        test("Emergency Patient",
                bill(35, true, false, false, 1000, 1500) == 3500);

        test("Senior Citizen",
                bill(65, false, false, false, 1000, 1500) == 2900);

        test("Insurance Patient",
                bill(35, false, true, false, 1000, 1500) == 900);

        test("Follow-up Patient",
                bill(35, false, false, true, 1000, 1500) == 2750);

        test("Emergency + Insurance",
                bill(35, true, true, false, 1000, 1500) == 1050);

        test("Senior + Insurance",
                bill(65, false, true, false, 1000, 1500) == 870);

        test("Senior + Follow-up",
                bill(65, false, false, true, 1000, 1500) == 2700);

        System.out.println("\nHospital QA Testing Completed");
    }
}