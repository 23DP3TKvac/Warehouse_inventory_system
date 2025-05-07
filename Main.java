import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.print("\033[32m");
        Scanner scanner = new Scanner(System.in);
        Warehouse warehouse = new Warehouse(100);

        welcomeAnimation();

        while (true) {
            System.out.println("\n=== Warehouse management menu ===");
            System.out.println("1. Add product");
            System.out.println("2. Show all products");
            System.out.println("3. Category Filter");
            System.out.println("4. Sort products");
            System.out.println("5. Count all product cost");
            System.out.println("6. Show capacity/empty space");
            System.out.println("7. Export data to CSV");
            System.out.println("8. Remove product");
            System.out.println("0. Exit");
            System.out.print("Choose the action (0-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter product supplier: ");
                    String supplier = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Product newProduct = new Product(name, category, supplier, price, quantity);

                    try {
                        loadingAnimation();
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation.");
                    }

                    if (warehouse.addProduct(newProduct)) {
                        System.out.println("Product added successfully!");
                    } else {
                        System.out.println("Error: Not enough space in warehouse.");
                    }

                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 2:
                    loadingAnimation();
                    System.out.println("\nProduct list:");
                    warehouse.printProducts();
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 3:
                    System.out.print("Enter category: ");
                    String filterCategory = scanner.nextLine();
                    try {
                        loadingAnimation();
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation.");
                    }
                    warehouse.filterByCategory(filterCategory);
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                    case 4:
                    System.out.println("Choose a sorting option:");
                    System.out.println("1. Sort by Name");
                    System.out.println("2. Sort by Price (low to high)");
                    System.out.println("3. Sort by Price (high to low)");
                    System.out.println("4. Sort by Quantity");
                    System.out.println("5. Sort by Supplier");
                    System.out.print("Your choice: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                
                    switch (sortChoice) {
                        case 1:
                            Collections.sort(warehouse.products, Product.NameComparator);
                            System.out.println("Products sorted by Name:");
                            break;
                        case 2:
                            Collections.sort(warehouse.products, Product.PriceComparator);
                            System.out.println("Products sorted by Price (low to high):");
                            break;
                        case 3:
                            Collections.sort(warehouse.products, Product.PriceDescendingComparator);
                            System.out.println("Products sorted by Price (high to low):");
                            break;
                        case 4:
                            Collections.sort(warehouse.products, Product.QuantityComparator);
                            System.out.println("Products sorted by Quantity:");
                            break;
                        case 5:
                            Collections.sort(warehouse.products, Product.SupplierComparator);
                            System.out.println("Products sorted by Supplier:");
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            return;
                    }
                    warehouse.printProducts();
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 5:
                    try {
                        loadingAnimation();
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation!");
                    }
                    System.out.println("Total warehouse value: $" + warehouse.calculateTotalValue());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 6:
                    loadingAnimation();
                    System.out.println("Warehouse capacity: " + warehouse.capacity);
                    System.out.println("Remaining space: " + warehouse.getRemainingSpace());
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 7:
                    System.out.print("Enter filename for CSV export: ");
                    String filename = scanner.nextLine();
                    warehouse.exportToCSV(filename);
                    try {
                        loadingAnimation();
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation!");
                    }
                    System.out.println("Data saved to inventory.csv");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 8:
                    loadingAnimation();
                    System.out.println("Current products in warehouse:");
                    warehouse.printProducts();
                    System.out.print("Enter product name to remove: ");
                    String productName = scanner.nextLine();
                    loadingAnimation();
                    if (warehouse.removeProduct(productName)) {
                        System.out.println("Product removed successfully!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 0:
                    try {
                        farewellAnimation();
                    } catch (InterruptedException e) {
                        System.out.println("Error during exit animation!");
                    }
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
            }
        }
    }

    private static void loadingAnimation() throws InterruptedException {
        String redSquare = "\033[0;31m■\033[32m";
        for (int i = 0; i < 5; i++) {
            System.out.print(redSquare);
            Thread.sleep(500);
        }
        System.out.println();
    }

    private static void welcomeAnimation() throws InterruptedException {
        clearConsole();
    
        System.out.println(" __        __   _                            _          ");
        System.out.println(" \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___    ");
        System.out.println("  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\ ");
        System.out.println("   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |   ");
        System.out.println("    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/ ");
        System.out.println();
    
        System.out.println("Warehouse Inventory System!");
        System.out.println("Loading");
        loadingAnimation();
        System.out.println("===========================\n");
    }

    private static void farewellAnimation() throws InterruptedException {
        clearConsole();

        System.out.println(" ____             ");
        System.out.println("| __ ) _   _  ____ ");
        System.out.println("|   \\| | | |/ __ \\");
        System.out.println("| |_) | |_| |  ___/");
        System.out.println("|____/\\__, |\\___|");
        System.out.println("       |___/      ");

        
        System.out.print("Exiting");
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println();
        clearConsole();
    }

    private static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}