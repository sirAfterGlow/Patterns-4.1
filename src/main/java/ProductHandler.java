import java.util.List;

public interface ProductHandler {
    Product findProductByName(String name);
    List<Product> getAvailableProducts();
    int howMuchLeft(Product product);
}
