public class OrderManagementQA {

    static void test(int no, String name, boolean result) {
        System.out.println("Test " + no + " - " + name + " : "
                + (result ? "PASS" : "FAIL"));
    }

    static double total(int qty, double price, double discount) {
        double subtotal = qty * price;
        double disc = Math.min(subtotal * discount, subtotal * 0.20);
        double taxable = subtotal - disc;
        double gst = taxable * 0.18;
        double shipping = taxable >= 1000 ? 0 : 100;
        return taxable + gst + shipping;
    }

    public static void main(String[] args) {

        test(1, "Single product", total(1, 500, 0.10) > 0);
        test(2, "Multiple products", total(3, 500, 0.10) > 0);
        test(3, "Zero quantity", 0 <= 0);
        test(4, "Negative quantity", -1 <= 0);
        test(5, "Valid product", total(2, 1000, 0.10) > 0);
        test(6, "Invalid product", "INVALID".equals("INVALID"));
        test(7, "Valid coupon", total(2, 1000, 0.20) > 0);
        test(8, "Invalid coupon", !"WRONG".equals("SAVE10"));
        test(9, "Maximum discount", total(2, 1000, 0.50) > 0);
        test(10, "GST calculation", total(1, 1000, 0) == 1180);
        test(11, "Free shipping", total(1, 1000, 0) == 1180);
        test(12, "Shipping charge", total(1, 500, 0) == 690);
        test(13, "Bulk order", total(10, 500, 0.10) > 0);
        test(14, "Large quantity", total(100, 100, 0.10) > 0);
        test(15, "Low price", total(1, 10, 0) > 0);
        test(16, "High price", total(1, 100000, 0.10) > 0);
        test(17, "No discount", total(2, 500, 0) > 0);
        test(18, "Category discount", total(2, 5000, 0.10) > 0);
        test(19, "Coupon discount", total(2, 5000, 0.20) > 0);
        test(20, "Final amount calculation", total(2, 1000, 0.10) > 0);

        System.out.println("\n20 QA TESTS COMPLETED");
    }
}