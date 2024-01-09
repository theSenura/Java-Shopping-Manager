abstract class Product implements Comparable<Product> {
    private String productID;
    private String productName;
    private int numAvailableItems;
    private double price;

    public Product(String productID,int numAvailableItems,String productName, double price) {
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
    public int compareTo(Product product){
        return this.productID.compareTo(product.productID);
    }
    public String toFile(){
            String details = productID+","+productName+","+numAvailableItems+","+price;
            return details;
    }
    @Override
    public String toString(){
        String details = "Product ID                   :"+productID+"\n"+
                "Product Name                 :"+productName+"\n"+
                "Number of products available :"+numAvailableItems+"\n"+
                "Price                        :"+price+"\n";
        return details;
    }
}
