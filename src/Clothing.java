public class Clothing extends Product{
    private String color;
    private int size;

    public Clothing(String productID, String productName, int numAvailableItems, double price, String color, int size) {
        super(productID, numAvailableItems,productName, price);
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
    public String toFile(){
        String details = super.toFile()+","+color+","+size+",Clothing"+"\n";
        return details;
    }
    public String toString(){
        String details = super.toString()+"\n"+
                "Color :"+color+"\n"+
                "Size :"+size+"\n"+
                "Category : Clothing";
        return details;
    }
}
