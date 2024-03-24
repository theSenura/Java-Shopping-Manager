import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {

    private ArrayList<Product> productList = new ArrayList<>();

    public ArrayList<Product> getProductList() {
        return productList;
    }



    //Method to check if the product ID already exists
    public void duplicateProduct(String productId) throws DuplicateProductException{
        for (Product product : productList) {
            if (productId.equals(product.getProductID())) {
                throw new DuplicateProductException("Product already exists");
            }
        }
    }

    //Method to add a product
    @Override
    public void addProduct(Scanner scanner) {
        int categoryNo;
        int numAvailableItems;
        String brand;
        int warranty;
        String color;
        int size;

        while (true) {
            if (productList.size() >= 50) { //Checking if the product list is full
                System.out.println("Max product count reached");
                break;
            }else {
                try { //try catch block to handle exceptions
                    System.out.print("Enter product ID: ");
                    String productID = scanner.next();
                    duplicateProduct(productID);

                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    scanner.nextLine();

                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();


                    System.out.print("Enter product category ( enter 1 for electronics, 2 for clothing): ");
                    categoryNo = scanner.nextInt();
                    if (categoryNo==1){
                        System.out.print("Enter the number of available items : ");
                        numAvailableItems = scanner.nextInt();
                        System.out.print("Enter brand : ");
                        brand = scanner.next();
                        System.out.print("Enter warranty period(months) : ");
                        warranty = scanner.nextInt();
                        Electronics electronics = new Electronics(productID, numAvailableItems,productName, price, brand, warranty);
                        productList.add(electronics);
                        System.out.println("New electronic product added successfully.");
                        System.out.println("\n");

                        break;
                    }
                    else if (categoryNo==2) {
                        System.out.print("Enter the number of available items : ");
                        numAvailableItems = scanner.nextInt();
                        System.out.print("Enter color : ");
                        color = scanner.next();
                        System.out.print("Enter size : ");
                        size = scanner.nextInt();
                        Clothing clothing = new Clothing(productID, numAvailableItems,productName, price,color, size);
                        productList.add(clothing);
                        System.out.println("New clothing product added successfully.");
                        System.out.println("\n");
                        break;
                    }
                    else { //if the user enters a number other than 1 or 2 for the category
                        System.out.println("Invalid input");

                    }

                }
                catch (DuplicateProductException e){ //If the Product ID already exists
                    System.out.println("Invalid input "+e.getMessage());
                }
                catch (InputMismatchException e){ //If the user enters a string for a number
                    System.out.println("Invalid input type");
                    scanner.nextLine();
                }

            }
        }
    }

    //Method to delete a product
    @Override
    public void deleteProduct(Scanner scanner) {
        boolean available = false; //boolean variable to check if the product ID exists
        while (!available){
        System.out.print("Enter product ID to delete: ");
        String productId = scanner.next();


        for (Product product : productList) {
            if (productId.equals(product.getProductID())) {
                System.out.println(product.toString());
                productList.remove(product);
                available = true;
                System.out.println("Product "+product.getProductName() +" deleted successfully");
                System.out.println("Total number of products left in the system : " + productList.size()+"\n");
                break;
            }
        }

        if (!available) { // Checking if the product ID exists
            System.out.println("Invalid product ID");
        }}
    }

    //Method to print the product list
    @Override
    public void printProductList() {
        System.out.println("Total number of products in the system : " + productList.size()+"\n");

        Collections.sort(productList); //Sorting the list using the overridden compareTo method
        for (Product product : productList) {
            System.out.println(product.toString());
        }

    }

    //Method to save the product list to a file
    @Override
    public void saveToFile() {
        FileWriter fileWriter; // Creating a FileWriter object
        try {
            fileWriter = new FileWriter("productList.txt"); //Creating a file
            //Writing the product details to the file
            for (Product product : productList) {
                fileWriter.write(product.toFile());
            }
            System.out.println("Product list saved to file \n");
            fileWriter.close();
        } catch (Exception e) { //Catching exceptions
            System.out.println("Error occurred"+e.getMessage());
        }

    }
    //Method to read the product list from the file
    @Override
    public void readFile() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("productList.txt"); //Creating a FileReader object
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) { //HasNextLine method to check if there is a next line
                String line = scanner.nextLine(); //Reading the next line
                //Split method to split the line into an array of strings using the comma as the separator
                String[] values = line.split(",");
                if (values[6].equals("Electronic")) {
                    //Creating an object of the Electronic class with the values from the file
                    Electronics electronics = new Electronics(values[0], Integer.parseInt(values[2]), values[1], Double.parseDouble(values[3]), values[4], Integer.parseInt(values[5]));
                    productList.add(electronics);
                } else if (values[6].equals("Clothing")) {
                    //Creating an object of the Clothing class with the values from the file
                    Clothing clothing = new Clothing(values[0], Integer.parseInt(values[2]),values[1], Double.parseDouble(values[3]), values[4], Integer.parseInt(values[5]));
                    productList.add(clothing);
                }

            }

            fileReader.close();
            //Catching exceptions
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Creating a manager object
        WestminsterShoppingManager manager = new WestminsterShoppingManager();


        //Reading the file at the start of the program
        manager.readFile();
        System.out.println("------Welcome to Westminster Shopping Manager------");

        while (true) {
            int userChoice = 0;
            //Displaying the menu
            System.out.println("1. Add a product");
            System.out.println("2. Delete a product");
            System.out.println("3. Print the product list");
            System.out.println("4. Save to file");
            System.out.println("5. Read from file");
            System.out.println("6. GUI");
            System.out.println("7. Exit");
            try {
                System.out.print("Enter your choice number :");
                userChoice = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }


            switch (userChoice) {
                case 1:
                    manager.addProduct(scanner);
                    break;
                case 2:
                    manager.deleteProduct(scanner);
                    break;
                case 3:
                    manager.printProductList();
                    break;
                case 4:
                    manager.saveToFile();
                    break;
                case 5:
                    manager.readFile();
                    break;
                case 6:
                    new LoginPage(manager);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");

            }
        }

    }
}

