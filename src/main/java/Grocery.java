public class Grocery extends Product {
    protected int calories;

    public Grocery(String name, String measure, int price, int calories) {
        super(name, measure, price);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    //    public String getName() {
//        return supername;
//    }
//
//    public String getMeasure() {
//        return measure;
//    }
//
//    public int getPrice() {
//        return price;
//    }

//    public boolean supply(int count) {
//        if (count > 0) {
//            this.count += count;
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean sell(int count) {
//        if (this.count >= count && count > 0) {
//            this.count -= count;
//            return true;
//        } else {
//            return false;
//        }
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "name='" + name + '\'' +
//                ", measure='" + measure + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
