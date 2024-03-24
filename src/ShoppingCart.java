import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> shoppingList;
    private double totalAmount;
    private User user;
    ShoppingCart(User user){
        this.shoppingList = new ArrayList<>();
        this.user = user;

    }
    public void addItem(Product product){
        shoppingList.add(product);

    }
    public void removeItem(Product product){
        shoppingList.remove(product);

    }

    public int getSameCategory(Product product){
        int quantity = 0;
        for (Product product2:this.getShoppingList()){
            if (product.getCategory().equals(product2.getCategory())){
                quantity++;
            }
        }
        return quantity;
    }

    public double sameItemCategoryDiscount(ShoppingCart shoppingCart){
        double discount = 0;
        double total = 0;
        for (Product product: shoppingCart.getShoppingList()){
            total +=product.getPrice();
            if (getSameCategory(product) >=3){
                discount = total*0.2;
            }
        }
        return discount;
    }

    public double firstPurchaseDiscount(ShoppingCart shoppingCart,boolean isNewUser){
        double discount = 0;
        if (isNewUser){
            for (Product product:shoppingCart.getShoppingList()){
                discount += product.getPrice()*0.1;
            }
        }
        return discount;
    }

    public double calculateTotal(ShoppingCart shoppingCart){
        for (Product product: shoppingCart.getShoppingList()) {
            totalAmount += product.getPrice();
        }
        totalAmount -= sameItemCategoryDiscount(shoppingCart);
        totalAmount -= firstPurchaseDiscount(shoppingCart,user.getNewUser());
        return totalAmount;

    }

    public ArrayList<Product> getShoppingList() {
        return shoppingList;
    }
    public int getQuantity(Product product){
        int quantity = 0;
        for (Product product2:this.getShoppingList()){
            if (product.getProductID().equals(product2.getProductID())){
                quantity++;
            }
        }
        return quantity;

    }
    public double getProductTotal(Product product){
        double productTotal = 0;
        for (Product product2:this.getShoppingList()){
            if (product.getProductID().equals(product2.getProductID())){
                productTotal = product.getPrice()*getQuantity(product);
            }
        }
        return productTotal;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
