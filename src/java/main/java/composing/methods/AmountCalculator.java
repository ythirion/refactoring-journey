package composing.methods;

public class AmountCalculator {
    public static double calculatePrice(double amount, int age) {
        double discountBasedOnAge = calculateDiscountBasedOnAge(amount, age);
        return amount - discountBasedOnAge;
    }

    public static double calculatePrice(Order order, boolean applyAgeDiscount, int age) {
        double total = order.totalPrice();
        double discount = applyAgeDiscount ? calculateDiscountBasedOnAge(total, age) : 0.0;

        return total - discount;
    }

    private static double calculateDiscountBasedOnAge(double amount, int age) {
        double ratio = 0;

        if (age <= 16) {
            ratio = 0.35;
        } else if (age >= 60) {
            ratio = 0.2;
        }
        return ratio * amount;
    }
}