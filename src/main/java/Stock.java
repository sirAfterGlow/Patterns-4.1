import java.util.*;

public class Stock implements ProductHandler {

    private static Stock instance = null;
    private Map<Product, Integer> stockProducts = new HashMap<>();

    private Stock() {
        stockProducts.put(new Grocery("Хлеб", "Булка", 32, 110), 30);
        stockProducts.put(new Grocery("Бананы", "Кг", 119, 30), 25);
        stockProducts.put(new Grocery("Гречка", "Паекет 1 кг", 179, 55), 20);
        stockProducts.put(new Grocery("Куринное филе", "Кг", 349, 240), 10);
        stockProducts.put(new Grocery("Молоко", "Пакет 1л", 69, 80), 20);
        stockProducts.put(new Grocery("Квас", "Бутылка 2л", 129, 20), 40);
    }


    public static Stock getInstance() {
        if (instance == null) {
            instance = new Stock();
        }
        return instance;
    }

    public Product findProductByName(String name) {
        for (Product product : stockProducts.keySet()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAvailableProducts() {
        List<Product> availableProducts = new ArrayList<>();

        for (Product product : stockProducts.keySet()) {
            if (stockProducts.get(product) > 0) {
                availableProducts.add(product);
            }
        }
        return availableProducts;
    }

    @Override
    public int howMuchLeft(Product product) {
        return stockProducts.get(product);
    }

    public boolean takeProduct(Product product, int count) {
        int stockCount = stockProducts.get(product);
        if (stockCount >= count) {
            stockProducts.replace(product, stockCount - count);
            return true;
        } else {
            return false;
        }
    }




}
