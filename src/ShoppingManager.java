import java.util.ArrayList;
import java.util.Scanner;

public interface ShoppingManager {

    void addProduct(Scanner scanner);
    void deleteProduct(Scanner scanner);
    void printProductList();
    void saveToFile();
    void readFile();

}
