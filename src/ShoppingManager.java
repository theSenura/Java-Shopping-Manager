import java.util.Scanner;

public interface ShoppingManager {

    void addProduct(Product product, Scanner scanner);
    void deleteProduct(String productID,Scanner scanner);
    void printProductList();
    void saveToFile();

}
