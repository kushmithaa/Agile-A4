public class OrderManagement {

    static void process(String product, String category,
                        int quantity, double price,
                        String coupon) {

        if (quantity <= 0) {
            System.out.println("Invalid quantity");
            return;
        }

        double subtotal = quantity * price;

        double categoryDiscount =
                category.equalsIgnoreCase("ELECTRONICS") ? subtotal * 0.10 :
                category.equalsIgnoreCase("CLOTHING") ? subtotal * 0.15 :
                subtotal * 0.05;

        double couponDiscount =
                coupon.equals("SAVE10") ? subtotal * 0.10 : 0;

        double discount = Math.min(
                categoryDiscount + couponDiscount,
                subtotal * 0.20);

        double taxable = subtotal - discount;
        double gst = taxable * 0.18;
        double shipping = taxable >= 1000 ? 0 : 100;
        double finalAmount = taxable + gst + shipping;

        System.out.println("=== E-COMMERCE ORDER ===");
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("Discount: %.2f%n", discount);
        System.out.printf("GST: %.2f%n", gst);
        System.out.printf("Shipping: %.2f%n", shipping);
        System.out.printf("Final Amount: %.2f%n", finalAmount);
    }

    public static void main(String[] args) {
        process("Laptop", "ELECTRONICS", 2, 50000, "SAVE10");
    }
}