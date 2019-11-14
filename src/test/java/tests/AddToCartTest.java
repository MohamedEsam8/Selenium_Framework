package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCartTest extends TestBase {

    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    String productname = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
    CartPage cart;
    String quantity = "4";

    @Test(priority = 1)
    public void usercansearchbyautocomplete()
    {
        try {
            searchpageobject = new SearchPage(driver);
            searchpageobject.seachproductbyautocomplete("hp envy");
            productobject = new ProductDetailsPage(driver);
            Assert.assertTrue(productobject.productnameindirectory.getText().equals(productname));
        }catch (Exception e){
            System.out.println("Error occurred " + e.getMessage());
        }

    }

    @Test(priority = 2)
    public void usercanaddproducttocart()
    {
        productobject.addtocart();
        Assert.assertTrue(productobject.addtocartmsg.getText().contains("The product has been added to your"));
        System.out.println(productobject.addtocartmsg.getText());
        productobject.opencartpage();
        cart = new CartPage(driver);
        Assert.assertTrue(cart.productprice.getText().equals("$1,460.00"));
        System.out.println(cart.productprice.getText());
        cart.increasequantityandupdate(quantity);
        Assert.assertTrue(cart.updatedprice.getText().equals("$5,840.00"));
        System.out.println(cart.updatedprice.getText());
        cart.removeproductandupdate();
        Assert.assertTrue(cart.confirmmsg.getText().equals("Your Shopping Cart is empty!"));
        System.out.println(cart.confirmmsg.getText());
    }
}
