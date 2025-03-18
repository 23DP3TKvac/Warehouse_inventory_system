import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Product> products = new ArrayList<>();
    int capacity;
    int currentLoad = 0;

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    public boolean addProduct(Product product) {
        if (currentLoad + product.quantity <= capacity) {
            products.add(product);
            currentLoad += product.quantity;
            return true;
        } else {
            return false;
        }
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("Warehouse is empty...");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    public void filterByCategory(String category) {
        boolean found = false;
        for (Product p : products) {
            if (p.category.equalsIgnoreCase(category)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Error! Products not found ;(");
        }
    } 
    
    public double calculateTotalValue() {
        double total = 0;

        for (Product p : products) {
            total += p.price * p.quantity;
        }
        return total;
    }

    public int getReamainingSpace() {
        return capacity - currentLoad;
    }

    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Name, Category, Supplier, Price, Quantity\n");
            for (Product p : products){
                writer.write(p.name + "," + p.category + "," + p.supplier + "," + p.price + "," + p.quantity + "\n");
            }
            System.out.println("Data are saved in " + filename + " :)");
        } catch (IOException e) {
            System.out.println("File saving error! ;(");
        }
    }
}
