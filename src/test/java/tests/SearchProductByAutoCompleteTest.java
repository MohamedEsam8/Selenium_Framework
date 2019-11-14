package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductByAutoCompleteTest extends TestBase {

    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    String productname = "Apple MacBook Pro 13-inch";

    @Test
    public void usercansearchbyautocomplete()
    {
        try {
            searchpageobject = new SearchPage(driver);
            searchpageobject.seachproductbyautocomplete("Mac");
            productobject = new ProductDetailsPage(driver);
            Assert.assertTrue(productobject.productnameindirectory.getText().equals(productname));
        }catch (Exception e){
            System.out.println("Error occurred " + e.getMessage());
        }

    }
}
