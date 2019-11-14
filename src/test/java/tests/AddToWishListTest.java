package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddToWishListTest  extends TestBase{

    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    String productname = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
    WishListPage wishpage;

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
    public void usercanaddproducttowishlist()
    {
        productobject.addtowishlist();
        Assert.assertTrue(productobject.confirmaddmsg.getText().contains("The product has been added to your"));
        System.out.println(productobject.confirmaddmsg.getText());
        productobject.openwishlist();
        wishpage = new WishListPage(driver);
        Assert.assertTrue(wishpage.productnm.getText().contains("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
        System.out.println(wishpage.productnm.getText());

    }

    @Test(priority = 3)
    public void usercanremoveproductfromwishlist()
    {
        wishpage.removeproduct();
        wishpage.updatewishlist();
        Assert.assertTrue(wishpage.upadtemsg.getText().contains("The wishlist is empty!"));
        System.out.println(wishpage.upadtemsg.getText());
    }
}
