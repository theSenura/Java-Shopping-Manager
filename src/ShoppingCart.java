import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> shoppingList;
    private double totalAmount;
    ShoppingCart(){
        shoppingList =  new ArrayList<Product>();
    }
    public void addItem(Product product){
        shoppingList.add(product);

    }
    public void removeItem(Product product){
        shoppingList.remove(product);

    }
    public double calculateTotal(){
        for (Product product: shoppingList) {
            totalAmount += product.getPrice();
        }
        return totalAmount;

    }





}
