package composing.methods;

public class OrderHelper {
    private static final int MINIMUM_ITEMS_IN_STOCK = 10;

    public static boolean deserveDiscount(Order order) {
        return order.totalPrice() > 1000;
    }

    // Customer deserves a discount if customer age / number of products < 5
    public static boolean deserveDiscountBasedOnCustomer(Order order) {
        double nbOfProducts = order.getProducts().size();
        int customerAge = order.getCustomer().getAge();

        return (customerAge / nbOfProducts) < 5;
    }

    public static int calculateNewStock(Stock stock, int outFromStock) {
        stock.setNbOfItems(stock.getNbOfItems() - outFromStock);

        if (stock.getNbOfItems() < MINIMUM_ITEMS_IN_STOCK) {
            return stock.getNbOfItems() + MINIMUM_ITEMS_IN_STOCK;
        }
        return stock.getNbOfItems();
    }
}