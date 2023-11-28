public class Clothing extends Product{
    private String color;
    private int size;

    public Clothing(String productID, String productName, int numAvailableItems, double price, String color, int size) {
        super(productID, productName, numAvailableItems, price);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
