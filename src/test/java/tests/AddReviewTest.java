package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddReviewTest extends TestBase {

    HomePage homeobject;
    RegistrationPage registrationobject;
    String productname = "Apple MacBook Pro 13-inch";
    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    AddReviewPage add;

    @Test(priority = 1 , enabled = true)
    public void usercanregister()
    {
        homeobject =new HomePage(driver);
        homeobject.openregistrationpage();
        registrationobject =new RegistrationPage(driver);
        registrationobject.UserRegistration("Mohamed","Tawfiq","m777m777@test.com","12345678");
        Assert.assertTrue(registrationobject.confrimmassege.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void Usercansearchforproduct()
    {
        searchpageobject = new SearchPage(driver);
        searchpageobject.seachforproduct(productname);
        searchpageobject.openproductdetailspage();
        productobject = new ProductDetailsPage(driver);
        Assert.assertTrue(productobject.productnameindirectory.getText().equals(productname));

    }

    @Test(priority = 3)
    public void Usercanaddreview()
    {
        productobject.addreview();
        add = new AddReviewPage(driver);
        add.addreview("hello" , "very good");
        Assert.assertTrue(add.cnfmsg.getText().contains("Product review is successfully added."));
    }

    @Test(priority = 4)
    public void usercanlogout()
    {
        registrationobject.UserLogout();
    }
}
