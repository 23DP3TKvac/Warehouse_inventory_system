import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
            return;
        }

        int nameWidth = 15, categoryWidth = 15, supplierWidth = 15, priceWidth = 10, quantityWidth = 10;

        for (Product product : products) {
            nameWidth = Math.max(nameWidth, product.getName().length() + 2);
            categoryWidth = Math.max(categoryWidth, product.getCategory().length() + 2);
            supplierWidth = Math.max(supplierWidth, product.getSupplier().length() + 2);
        }

        String format = "| %-"+nameWidth+"s | %-"+categoryWidth+"s | %-"+supplierWidth+"s | %"+priceWidth+".2f | %"+quantityWidth+"d |\n";

        printTableBorder(nameWidth, categoryWidth, supplierWidth, priceWidth, quantityWidth);

        System.out.printf("| %-"+nameWidth+"s | %-"+categoryWidth+"s | %-"+supplierWidth+"s | %"+priceWidth+"s | %"+quantityWidth+"s |\n",
                "Name", "Category", "Supplier", "Price $", "Quantity");

        printTableBorder(nameWidth, categoryWidth, supplierWidth, priceWidth, quantityWidth);

        for (Product product : products) {
            System.out.printf(format, 
                    product.getName(), product.getCategory(), product.getSupplier(),
                    product.getPrice(), product.getQuantity());
        }

        printTableBorder(nameWidth, categoryWidth, supplierWidth, priceWidth, quantityWidth);
    }

    private void printTableBorder(int nameW, int catW, int supW, int priceW, int qtyW) {
        System.out.println("+" + "-".repeat(nameW + 2) + "+" + "-".repeat(catW + 2) + "+" 
                + "-".repeat(supW + 2) + "+" + "-".repeat(priceW + 2) + "+" + "-".repeat(qtyW + 2) + "+");
    }

    public void filterByCategory(String category) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }

        if (filteredProducts.isEmpty()) {
            System.out.println("Category '" + category + "' is empty...");
            return;
        }

        printFilteredProducts(filteredProducts);
    }

    public void filterByFirstLetter(char letter) {
        ArrayList<Product> filteredProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toUpperCase().charAt(0) == letter) {
                filteredProducts.add(product);
            }
        }

        if (filteredProducts.isEmpty()) {
            System.out.println("No products start with the letter '" + letter + "'...");
            return;
        }

        printFilteredProducts(filteredProducts);
    }

    public void filterByPrice(boolean ascending) {
        System.out.println("Sorting products by price: " + (ascending ? "Low to High" : "High to Low"));
        products.sort((p1, p2) -> ascending ? Double.compare(p1.getPrice(), p2.getPrice()) : Double.compare(p2.getPrice(), p1.getPrice()));
        printProducts();
    }

    public void filterByQuantity(boolean ascending) {
        System.out.println("Sorting products by quantity: " + (ascending ? "Low to High" : "High to Low"));
        products.sort((p1, p2) -> ascending ? Integer.compare(p1.getQuantity(), p2.getQuantity()) : Integer.compare(p2.getQuantity(), p1.getQuantity()));
        printProducts();
    }

    public void filterBySupplier(String supplier) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        
        for (Product product : products) {
            if (product.getSupplier().equalsIgnoreCase(supplier)) {
                filteredProducts.add(product);
            }
        }

        if (filteredProducts.isEmpty()) {
            System.out.println("No products from supplier '" + supplier + "'...");
            return;
        }

        printFilteredProducts(filteredProducts);
    }

    private void printFilteredProducts(ArrayList<Product> filteredProducts) {
        int nameWidth = 15, categoryWidth = 15, supplierWidth = 15, priceWidth = 10, quantityWidth = 10;

        for (Product product : filteredProducts) {
            nameWidth = Math.max(nameWidth, product.getName().length() + 2);
            categoryWidth = Math.max(categoryWidth, product.getCategory().length() + 2);
            supplierWidth = Math.max(supplierWidth, product.getSupplier().length() + 2);
        }

        String format = "| %-"+nameWidth+"s | %-"+categoryWidth+"s | %-"+supplierWidth+"s | %"+priceWidth+".2f | %"+quantityWidth+"d |\n";

        printTableBorder(nameWidth, categoryWidth, supplierWidth, priceWidth, quantityWidth);

        System.out.printf("| %-"+nameWidth+"s | %-"+categoryWidth+"s | %-"+supplierWidth+"s | %"+priceWidth+"s | %"+quantityWidth+"s |\n",
                "Name", "Category", "Supplier", "Price $", "Quantity");

        printTableBorder(nameWidth, categoryWidth, supplierWidth, priceWidth, quantityWidth);

        for (Product product : filteredProducts) {
            System.out.printf(format, 
                    product.getName(), product.getCategory(), product.getSupplier(),
                    product.getPrice(), product.getQuantity());
        }

        printTableBorder(nameWidth, categoryWidth, supplierWidth, priceWidth, quantityWidth);
    }

    public double calculateTotalValue() {
        double total = 0;

        for (Product p : products) {
            total += p.price * p.quantity;
        }
        return total;
    }

    public int getRemainingSpace() {
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

    public boolean removeProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}