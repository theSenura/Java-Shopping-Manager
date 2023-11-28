import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> listProducts;
    private double totalAmount;
    ShoppingCart(){
        listProducts =  new ArrayList<Product>();
    }
    public void addItem(Product product){
        listProducts.add(product);

    }
    public void removeItem(Product product){
        listProducts.remove(product);

    }
    public double calculateTotal(){
        for (Product product: listProducts) {
            totalAmount += product.getPrice();
        }
        return totalAmount;

    }





}
