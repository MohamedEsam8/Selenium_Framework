package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCompareListTest extends TestBase {

    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    CompareListPage comparepage;

    @Test(priority = 1)
    public void usercansearchbyautocomplete()
    {
        try {
            searchpageobject = new SearchPage(driver);
            searchpageobject.seachproductbyautocomplete("mac");
            productobject = new ProductDetailsPage(driver);
            Assert.assertTrue(productobject.productnameindirectory.getText().equals("Apple MacBook Pro 13-inch"));
        }catch (Exception e){
            System.out.println("Error occurred " + e.getMessage());
        }

    }

    @Test(priority = 2)
    public void usercanaddproducttocomparelist()
    {
        productobject.addtocomparelist();
        Assert.assertTrue(productobject.confirmaddtocomparemsg.getText().contains("The product has been added to your"));
        System.out.println(productobject.confirmaddtocomparemsg.getText());
    }

    @Test(priority = 3)
    public void usercansearchbyautocomplete2()
    {
        try {
            searchpageobject.seachproductbyautocomplete("asus");
            Assert.assertTrue(productobject.productnameindirectory.getText().equals("Asus N551JK-XO076H Laptop"));
        }catch (Exception e){
            System.out.println("Error occurred " + e.getMessage());
        }

    }

    @Test(priority = 4)
    public void usercanaddanotherproducttocomparelist()
    {
        productobject.addtocomparelist();
        Assert.assertTrue(productobject.confirmaddtocomparemsg.getText().contains("The product has been added to your"));
        System.out.println(productobject.confirmaddtocomparemsg.getText());
        productobject.opencomparelist();
    }

    @Test(priority = 5)
    public void usercanshowproductsdetails()
    {
        comparepage = new CompareListPage(driver);
        Assert.assertTrue(comparepage.cpu1.getText().contains("Intel Core i7"));
        System.out.println(comparepage.cpu1.getText());
        Assert.assertTrue(comparepage.cpu2.getText().contains("Intel Core i5"));
        System.out.println(comparepage.cpu2.getText());
        comparepage.listallproductdetails();
    }

    @Test(priority = 6)
    public void usercanremoveproductsfromcommparelist()
    {
        comparepage.removeproducts();
        Assert.assertTrue(comparepage.confirmremovemsg.getText().contains("You have no items to compare."));
        System.out.println(comparepage.confirmremovemsg.getText());
    }
}
