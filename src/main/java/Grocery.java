public class Grocery extends Product {
    protected int calories;

    public Grocery(String name, String measure, int price, int calories) {
        super(name, measure, price);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}
