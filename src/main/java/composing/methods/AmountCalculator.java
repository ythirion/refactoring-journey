package composing.methods;

public class AmountCalculator {
    public static double calculatePrice(double amount, int age){
        double discountBasedOnAge = 0;

        if(age <= 16){
            discountBasedOnAge = 0.35 * amount;
        } else if(age >= 60){
            discountBasedOnAge = 0.2 * amount;
        }
        return amount - discountBasedOnAge;
    }

    public static double calculatePrice(Order order, boolean applyAgeDiscount, int age){
        double result = 0.0;
        double discount = 0.0;
        double resultWithDiscount = 0.0;

        for (Product product: order.getProducts()) {
            result += product.getPrice();
        }

        if(applyAgeDiscount) {
            double discountBasedOnAge = 0;
            if (age <= 16) {
                discountBasedOnAge = 0.35 * result;
            } else if (age >= 60) {
                discountBasedOnAge = 0.2 * result;
            }
            discount = discountBasedOnAge;
        }
        resultWithDiscount = result - discount;

        return resultWithDiscount;
    }
}