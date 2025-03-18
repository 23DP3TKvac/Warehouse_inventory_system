import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnanner = new Scanner(System.in);
        Warehouse warehouse = new Warehouse(100);
        
        while (true) {
            System.out.println("\n=== Warehouse management menu===");
            System.out.println("1. Add product");
            System.out.println("2. Show all products");
            System.out.println("3. Category Filter");
            System.out.println("4. Count all product cost");
            System.out.println("5. Show capacity/empty space");
            System.out.println("6. Export data to CSV");
            System.out.println("0. Execute the program");
            System.out.print("Choose the action");

            int choice = scnanner.nextInt();
            scnanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String category = scanner.nextLine();
                    
                    System.out.print("Enter product name: ");
                    String supplier = scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String price = scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String quantity = scanner.nextLine();

                    Product newProduct = new Product(name, category, supplier, price, quantity);

                    System.out.print("Adding...");
                    loadingAnimation();
                    if (warehouse.addProduct(newProduct)) {
                        System.out.println("Product is added succesfully!!! ;)");
                    } else {
                        System.out.println("Error! Not enough space on warehouse ;(");
                    }
                    break;

                case 2:
                    System.out.println("\nProduct list:");
                    warehouse.printProducts();
                    break;

                case 3:
                    System.out.print("Enter category: ");
                    String filterCategory = scanner.nextLine();
                    loadingAnimation();
                    warehouse.filterByCategory(filterCategory);
                    break;

                case 4:
                    System.out.println("calculating...");
                    loadingAnimation();
                    System.out.println("Total value: $" + warehouse.calculateTotalValue());
                    break;

                case 5:
                    System.out.println("Warehouse capacity: " + warehouse.capacity + "pc.");
                    System.out.println("Space left:" + warehouse.getReamainingSpace() + "pc.");
                    break;

                case 6:
                    System.out.println("Exporting...");
                    loadingAnimation();
                    warehouse.exportToCSV("inventory.csv");
                    break;

                case 0:
                    exitAnimation();
                    scanner.close();
                    return;

                default:
                    System.out.println("Error: wrong choice ;(. Try again!");
            }
        }
    }

    private static void loadingAnimation() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(300);
        }
        System.out.println();
    }
}