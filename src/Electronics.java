public class Electronics extends Product{
    private String brand;
    private int warranty;

    public Electronics(String productID,int numAvailableItems, String productName, double price, String brand, int warranty) {
        super(productID,numAvailableItems, productName, price); //Calling the constructor of the product class
        this.brand = brand;
        this.warranty = warranty;

    }

    public String getBrand() {
        return brand;
    }

    public int getWarranty() {
        return warranty;
    }
    public String getCategory(){
        return "Electronic";
    }



    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }


    public String toFile(){
            String details = super.toFile()+","+brand+","+warranty+",Electronic"+"\n";
            return details;
    }
    public String toString(){
        String details = super.toString()+
                "Brand                        :"+brand+"\n"+
                "Warranty                     :"+warranty+"\n"+
                "Category                     : Electronic"+ "\n"+
                "------------------------------------------";
        return details;
    }
}
