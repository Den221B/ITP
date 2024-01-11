import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SalesTracker {
    private LinkedList<String> soldProducts;
    private HashMap<String, Double> prices;

    public SalesTracker() {
        this.soldProducts = new LinkedList<>();
        this.prices = new HashMap<>();
    }

    public void addSale(String name, double price, int quantity) {
        prices.putIfAbsent(name, price);
        for (int i = 0; i < quantity; i++) {
            soldProducts.add(name);
        }
    }

    public void displaySales() {
        System.out.println("Список проданных товаров:");
        for (String product : soldProducts) {
            System.out.println(product + " - Цена: $" + prices.get(product));
        }
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            totalSales += entry.getValue();
        }
        return totalSales;
    }

    public String getMostPopularProduct() {
        if (soldProducts.isEmpty()) {
            return null;
        }
        Map<String, Long> counts = soldProducts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String mostPopularProduct = Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
        return mostPopularProduct;
    }

    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();
        salesTracker.addSale("T1", 1000, 1);
        salesTracker.addSale("T2", 500, 2);
        salesTracker.addSale("T3", 300, 4);
        salesTracker.displaySales();
        System.out.println("Общая сумма продаж: $" + salesTracker.calculateTotalSales());
        System.out.println("Самый популярный товар: " + salesTracker.getMostPopularProduct());
    }
}
