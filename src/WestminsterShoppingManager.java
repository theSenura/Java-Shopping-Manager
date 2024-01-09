import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {

    protected ArrayList<Product> productList = new ArrayList<>();

    public ArrayList<Product> getProductList() {
        return productList;
    }

    @Override
    public void addProduct(Scanner scanner) {
        int categoryNo;
        int numAvailableItems;
        String brand;
        int warranty;
        String color;
        int size;

        if (productList.size() >= 50) {
            System.out.println("Max product count reached");
        }else {

        System.out.print("Enter product ID: ");
        String productID = scanner.next();


        System.out.print("Enter product name: ");
        String productName = scanner.next();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        while (true) {
            try {
                System.out.print("Enter product category ( enter 1 for electronics, 2 for clothing): ");
                categoryNo = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Invalid input");
                continue;
            }
            if (categoryNo==1){
                System.out.print("Enter the number of available items : ");
                numAvailableItems = scanner.nextInt();
                System.out.print("Enter brand : ");
                brand = scanner.next();
                System.out.print("Enter warranty period : ");
                warranty = scanner.nextInt();
                Electronics electronics = new Electronics(productID, numAvailableItems,productName, price, brand, warranty);
                productList.add(electronics);
                System.out.println("New electronic product added successfully.");
                break;
            }
            else if (categoryNo==2) {
                System.out.print("Enter the number of available items : ");
                numAvailableItems = scanner.nextInt();
                System.out.print("Enter color : ");
                color = scanner.next();
                System.out.print("Enter size : ");
                size = scanner.nextInt();
                Clothing clothing = new Clothing(productID, productName, numAvailableItems, price,color, size);
                productList.add(clothing);
                System.out.println("New clothing product added successfully.");
                break;
            }
            else {
                System.out.println("Invalid input");

                }
            }
        }
    }
    @Override
    public void deleteProduct(Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        String productId = scanner.next();

        boolean available = false;
        for (Product product : productList) {
            if (productId.equals(product.getProductID())) {
                System.out.println(product.toString());
                productList.remove(product);
                available = true;
                System.out.println("Total number of products left in the system : " + productList.size());
                break;
            }
        }

        if (!available) {
            System.out.println("Invalid product ID");
        }
    }

    @Override
    public void printProductList() {
        Collections.sort(productList);
        for (Product product : productList) {
            System.out.println(product.toString());
        }

    }

    @Override
    public void saveToFile() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("productList.txt");
            for (Product product : productList) {
                fileWriter.write(product.toFile());
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error occurred");
        }

    }
    @Override
    public void readFile() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("productList.txt");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                if (values[6].equals("Electronic")) {
                    Electronics electronics = new Electronics(values[0], Integer.parseInt(values[2]), values[1], Double.parseDouble(values[3]), values[4], Integer.parseInt(values[5]));
                    productList.add(electronics);
                } else if (values[6].equals("Clothing")) {
                    Clothing clothing = new Clothing(values[0], values[2], Integer.parseInt(values[2]), Double.parseDouble(values[3]), values[4], Integer.parseInt(values[5]));
                    productList.add(clothing);
                }

            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
