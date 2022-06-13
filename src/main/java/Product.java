public abstract class Product {
    protected String name;
    protected String measure;
    protected int price;

    public Product(String name, String measure, int price) {
        this.name = name;
        this.measure = measure;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMeasure() {
        return measure;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", measure='" + measure + '\'' +
                ", price=" + price +
                '}';
    }
}
