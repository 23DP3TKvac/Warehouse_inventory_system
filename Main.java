import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.print("\033[32m");
        Scanner scanner = new Scanner(System.in); // Fixed variable name
        Warehouse warehouse = new Warehouse(100);
        // TODO
        // https://java-programming.mooc.fi/part-11/3-exceptions
        

        welcomeAnimation();

        while (true) {
            System.out.println("\n=== Warehouse management menu ===");
            System.out.println("1. Add product");
            System.out.println("2. Show all products");
            System.out.println("3. Category Filter");
            System.out.println("4. Count all product cost");
            System.out.println("5. Show capacity/empty space");
            System.out.println("6. Export data to CSV");
            System.out.println("7. Remove product");
            System.out.println("0. Execute the program");
            System.out.print("Choose the action (0-7): ");

            int choice = scanner.nextInt(); // Fixed variable name
            scanner.nextLine(); // Fixed variable name
            
            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine(); // Fixed variable name

                    System.out.print("Enter product category: "); // Fixed prompt
                    String category = scanner.nextLine(); // Fixed variable name
                    
                    System.out.print("Enter product supplier: "); // Fixed prompt
                    String supplier = scanner.nextLine(); // Fixed variable name

                    System.out.print("Enter product price: "); // Fixed prompt
                    double price = Double.parseDouble(scanner.nextLine()); // Convert to double

                    System.out.print("Enter product quantity: "); // Fixed prompt
                    int quantity = Integer.parseInt(scanner.nextLine()); // Convert to int

                    Product newProduct = new Product(name, category, supplier, price, quantity); // Fixed constructor arguments

                    System.out.print("Adding");
                    try {
                        loadingAnimation(); // Added exception handling
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation.");
                    }
                    if (warehouse.addProduct(newProduct)) {
                        System.out.println("Product is added successfully!!! ;)");
                    } else {
                        System.out.println("Error! Not enough space in warehouse ;(");
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
                    String filterCategory = scanner.nextLine(); // Fixed variable name
                    try {
                        loadingAnimation(); // Added exception handling
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation.");
                    }
                    warehouse.filterByCategory(filterCategory);
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 4:
                    System.out.println("Calculating");
                    try {
                        loadingAnimation(); // Added exception handling
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation!");
                    }
                    System.out.println("Total value: $" + warehouse.calculateTotalValue());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 5:
                    loadingAnimation();
                    System.out.println("Warehouse capacity: " + warehouse.capacity + "pc.");
                    System.out.println("Space left: " + warehouse.getRemainingSpace() + "pc."); // Fixed method name
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 6:
                    System.out.println("Exporting");
                    try {
                        loadingAnimation(); // Added exception handling
                    } catch (InterruptedException e) {
                        System.out.println("Error during loading animation!");
                    }
                    warehouse.exportToCSV("inventory.csv");
                    System.out.println("Data are saved in inventory.csv :)");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 7:
                    loadingAnimation();
                    System.out.println("Current products in warehouse:");
                    warehouse.printProducts();
                    System.out.println("Enter the name of the product you want to remove:");
                    String productName = scanner.nextLine();
                    System.out.println("Removing");
                    loadingAnimation();
                    if (warehouse.removeProduct(productName)) {
                        System.out.println("Product is removed successfully!");
                    } else {
                        System.out.println("Error! Product not found ;(");
                    }
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 0:
                    try {
                        exitAnimation(); // Added exception handling
                    } catch (InterruptedException e) {
                        System.out.println("Error during exit animation!");
                    }
                    scanner.close(); // Fixed variable name
                    return;

                default:
                    System.out.println("Error: wrong choice. Try again!");
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
        System.out.println("Welcome to Warehouse system!");
        System.out.println("Loading");
        loadingAnimation();
        System.out.println("===========================\n");
    }

    private static void exitAnimation() throws InterruptedException {
        System.out.println("\nShutting down");
        String redSquare = "\033[0;31m■\033[32m";
        for (int i = 0; i < 5; i++) {
            System.out.print(redSquare);
            Thread.sleep(500);
        }
        System.out.println("Bye!");
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("\033[H\033[2j");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }
}