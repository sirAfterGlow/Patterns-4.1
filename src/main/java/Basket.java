import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    protected Map<Product, Integer> content;

    public Basket() {
        content = new HashMap<>();
    }

    public boolean add(Product product, int count) {
        if (Stock.getInstance().takeProduct(product, count)) {
            if (content.get(product) == null) {
                content.put(product, count);
            } else {
                int basketCount = content.get(product);
                content.replace(product, basketCount + count);
            }
            return true;
        } else {
            return false;
        }
    }

    public Map<Product, Integer> getContent() {
        return content;
    }
}
