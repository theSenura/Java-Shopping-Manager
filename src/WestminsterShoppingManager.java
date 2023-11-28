import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {

    private ArrayList<Product> products = new ArrayList<>();


    @Override
    public void addProduct(Product product, Scanner scanner) {
        int category;
        int numAvailableItems;
        if (products.size() >= 50) {
            System.out.println("Cannot add more than 50 products.");
            return;
        }

        System.out.print("Enter product ID: ");
        int productID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        while (true) {
            try {
                System.out.print("Enter product category ( enter 1 for electronics, 2 for clothing): ");
                category = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Error");
                continue;
            }
            if (category==1){
                System.out.print("Enter product category ( enter 1 for electronics, 2 for clothing): ");
                numAvailableItems = scanner.nextInt();
                System.out.print("Enter product category ( enter 1 for electronics, 2 for clothing): ");
                brand = scanner.nextInt();
                System.out.print("Enter product category ( enter 1 for electronics, 2 for clothing): ");
                warranty = scanner.nextInt();
            Electronics electronics = new Electronics(productID, productName, numAvailableItems, price, brand, warranty);
            products.add(product);
            System.out.println("Product added successfully.");}
            else if (category==2) {
            Clothing clothing = new Electronics(productID, productName, numAvailableItems, price, brand, warranty);
            products.add(product);
            System.out.println("Product added successfully.");}
            else {

            }
        }
    }
    @Override
    public void deleteProduct(String productID,Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();

        boolean found = false;
        for (Product product : products) {
            if (product.getProductID() == productId) {
                System.out.println("Product ID " + productId + " (" + product.category + ") deleted.");
                products.remove(product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }

        System.out.println("Total number of products left in the system: " + products.size());
    }

    @Override
    public void printProductList() {

    }

    @Override
    public void saveToFile() {

    }
}
