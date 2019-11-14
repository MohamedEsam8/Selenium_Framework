package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisteredUserCheckOutTest extends TestBase {

    HomePage homeobject;
    RegistrationPage registrationobject;
    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    String productname = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
    CartPage cart;
    String quantity = "4";
    CheckoutPage chechout;
    OrderInfoPage order;

    @Test(priority = 1 , enabled = true)
    public void usercanregister()
    {
        homeobject =new HomePage(driver);
        homeobject.openregistrationpage();
        registrationobject =new RegistrationPage(driver);
        registrationobject.UserRegistration("Mohamed","Tawfiq","m8m8m6m6m8@test.com","12345678");
        Assert.assertTrue(registrationobject.confrimmassege.getText().contains("Your registration completed"));
    }


    @Test(priority = 2)
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

    @Test(priority = 3)
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
    }

    @Test(priority = 4)
    public void UsercanCheckOut()
    {
        cart.openchckoutpage();
        chechout = new CheckoutPage(driver);
        chechout.confirmcheckout("Egypt" , "Cairo" , "Alexandria" , "12345" , "01029452353");
        Assert.assertTrue(chechout.confirmmsg.getText().equals("Your order has been successfully processed!"));
        System.out.println(chechout.confirmmsg.getText());
        //chechout.endcheckout();
        chechout.opendetailspage();
        order = new OrderInfoPage(driver);
        order.downloadpdf();
    }

    @Test(priority = 5)
    public void usercanlogout()
    {
        registrationobject.UserLogout();
    }
}
