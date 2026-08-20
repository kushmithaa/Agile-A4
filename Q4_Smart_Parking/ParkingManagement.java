public class ParkingManagement {

    static double fee(String vehicle, int hours,
                      boolean lostTicket, boolean vip,
                      boolean peak, boolean ev) {

        if (lostTicket)
            return 500;

        double rate;

        switch (vehicle.toUpperCase()) {
            case "BIKE":  rate = 20; break;
            case "CAR":   rate = 40; break;
            case "SUV":   rate = 60; break;
            case "TRUCK": rate = 80; break;
            case "EV":    rate = 40; break;
            default:      return -1;
        }

        double amount = rate * hours;

        if (peak)
            amount *= 1.25;

        if (vip)
            amount *= 0.75;

        if (ev)
            amount += 50;

        return amount;
    }

    public static void main(String[] args) {

        double amount = fee(
                "CAR",
                3,
                false,
                false,
                false,
                false
        );

        System.out.println("=== SMART PARKING ===");
        System.out.println("Vehicle: CAR");
        System.out.println("Parking Hours: 3");
        System.out.printf("Parking Fee: %.2f%n", amount);
        System.out.println("Slot: CAR-01");
    }
}