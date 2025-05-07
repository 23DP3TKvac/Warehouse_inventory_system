import java.util.Comparator;

public class Product implements Comparable<Product> {
    String name;
    String category;
    String supplier;
    double price;
    int quantity;

    public Product(String name, String category, String supplier, double price, int quantity) {
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

    public static Comparator<Product> PriceComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return Double.compare(p1.price, p2.price);
        }
    };

    public static Comparator<Product> PriceDescendingComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return Double.compare(p2.price, p1.price);
        }
    };

    public static Comparator<Product> QuantityComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return Integer.compare(p1.quantity, p2.quantity);
        }
    };

    public static Comparator<Product> NameComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.name.compareToIgnoreCase(p2.name);
        }
    };

    public static Comparator<Product> SupplierComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.supplier.compareToIgnoreCase(p2.supplier);
        }
    };

    @Override
    public int compareTo(Product other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}