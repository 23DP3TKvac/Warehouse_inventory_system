
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

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + "(" + category + ") - " + price + "$ x " + quantity;
    }
}