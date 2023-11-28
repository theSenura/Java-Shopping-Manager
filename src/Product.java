abstract class Product {
    private String productID;
    private String productName;
    private int numAvailableItems;
    private double price;

    public Product(String productID, String productName, double price) {
        this.productID = productID;
        this.productName = productName;
        this.numAvailableItems = numAvailableItems;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getNumAvailableItems() {
        return numAvailableItems;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setNumAvailableItems(int numAvailableItems) {
        this.numAvailableItems = numAvailableItems;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
