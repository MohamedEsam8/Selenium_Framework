package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

    HomePage home;
    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    String productname = "Apple MacBook Pro 13-inch";

    @Test
    public void usercanchangecurrency()
    {
        home =new HomePage(driver);
        home.changecurrency();
    }

    @Test
    public void usercansearchbyautocomplete()
    {
        try {
            searchpageobject = new SearchPage(driver);
            searchpageobject.seachproductbyautocomplete("Mac");
            productobject = new ProductDetailsPage(driver);
            Assert.assertTrue(productobject.productnameindirectory.getText().equals(productname));
            Assert.assertTrue(productobject.productprice.getText().contains("Ђ"));
        }catch (Exception e){
            System.out.println("Error occurred " + e.getMessage());
        }
    }
}
