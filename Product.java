
public class Product {
    String name;
    String category;
    String supplier;
    double price;
    int quantity;

    public Product (String name, String category, String supplier, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + "(" + category + ") - " + price + "$ x " + quantity;
    }
}