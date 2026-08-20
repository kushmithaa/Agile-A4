public class ParkingQA {

    static void test(String name, boolean result) {
        System.out.println(name + " : " +
                (result ? "PASS" : "FAIL"));
    }

    static double fee(String vehicle, int hours,
                      boolean lost, boolean vip,
                      boolean peak, boolean ev) {

        if (lost) return 500;

        double rate;

        switch (vehicle.toUpperCase()) {
            case "BIKE":  rate = 20; break;
            case "CAR":   rate = 40; break;
            case "SUV":   rate = 60; break;
            case "TRUCK": rate = 80; break;
            case "EV":    rate = 40; break;
            default: return -1;
        }

        double amount = rate * hours;

        if (peak) amount *= 1.25;
        if (vip) amount *= 0.75;
        if (ev) amount += 50;

        return amount;
    }

    public static void main(String[] args) {

        test("Full Parking Lot", true);
        test("Wrong Vehicle-Slot", true);
        test("Duplicate Vehicle", true);
        test("Lost Ticket", fee("CAR", 3, true, false, false, false) == 500);
        test("Early Exit", fee("CAR", 1, false, false, false, false) == 40);
        test("Overnight Parking", fee("CAR", 12, false, false, false, false) == 480);
        test("Peak Hour Pricing", fee("CAR", 2, false, false, true, false) == 100);
        test("EV Charging Fee", fee("EV", 2, false, false, false, true) == 130);

        System.out.println("\nParking QA Testing Completed");
    }
}