import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterShoppingManagerTest {

    //Creating two products for testing
    Product product = new Electronics("E001",4,"Laptop",1000,"Asus",12);
    Product product2 = new Clothing("C001",2,"Shirt",100,"Blue",3);
    //Creating a manager object
    WestminsterShoppingManager manager = new WestminsterShoppingManager();

    @Test
     void checkProductIsAdded() {
        manager.getProductList().add(product);
        manager.getProductList().add(product2);
        assertTrue(manager.getProductList().contains(product)); //Checking if the product is in the list
        assertTrue(manager.getProductList().contains(product2)); //Checking if the product is in the list

    }

    @Test
    void checkProductCategory() {
        manager.getProductList().add(product);
        manager.getProductList().add(product2);
        assertEquals("Electronic",manager.getProductList().get(0).getCategory()); //Checking if the category is Electronic
        assertEquals("Clothing",manager.getProductList().get(1).getCategory()); //Checking if the category is Clothing
    }

    @Test
    void checkProductIsRemoved() {
        manager.getProductList().add(product);
        manager.getProductList().add(product2);
        manager.getProductList().remove(product);

        //Checking if the product is removed from the list
        assertFalse(manager.getProductList().contains(product));
    }

    @Test
    void checkProductListIsSorted() {
        manager.getProductList().add(product);
        manager.getProductList().add(product2);
        Collections.sort(manager.getProductList()); //Sorting the list
        assertEquals(product2,manager.getProductList().get(0)); //If the list is sorted, the first element should be product2
    }

    @Test
    void saveAndReadTheProductFile() {

        manager.getProductList().add(product);
        manager.getProductList().add(product2);
        int listSize = manager.getProductList().size();
        manager.saveToFile(); //Saving the list to the file
        manager.getProductList().clear();
        manager.readFile(); //Reading the file

        //Checking if the productID's in the file and the list are equal
        assertEquals(product.getProductID(), manager.getProductList().get(0).getProductID());
        assertEquals(product2.getProductID(), manager.getProductList().get(1).getProductID());
        //Checking if the initial list size and the list size after reading the file are equal
        assertEquals(listSize,manager.getProductList().size());

    }

    @Test
    void checkProductDetails() {
        manager.getProductList().add(product);
        manager.getProductList().add(product2);

        //Checking toString method displays the correct details
        assertEquals("""
                Product ID                   :E001
                Product Name                 :Laptop
                Number of products available :4
                Price                        :1000.0
                Brand                        :Asus
                Warranty                     :12
                Category                     : Electronic
                ------------------------------------------""",product.toString());
        assertEquals("""
                Product ID                   :C001
                Product Name                 :Shirt
                Number of products available :2
                Price                        :100.0
                Color                        :Blue
                Size                        :3
                Category                     : Clothing
                ------------------------------------------""",product2.toString());
    }
}