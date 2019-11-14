package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

    String productname = "Apple MacBook Pro 13-inch";
    SearchPage searchpageobject;
    ProductDetailsPage productobject;

    @Test
    public void Usercansearchforproduct()
    {
        searchpageobject = new SearchPage(driver);
        searchpageobject.seachforproduct(productname);
        searchpageobject.openproductdetailspage();
        productobject = new ProductDetailsPage(driver);
        Assert.assertTrue(productobject.productnameindirectory.getText().equals(productname));

    }
}
