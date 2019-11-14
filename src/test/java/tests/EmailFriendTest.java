package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase {

    HomePage homeobject;
    RegistrationPage registrationobject;
    String productname = "Apple MacBook Pro 13-inch";
    String friendmail = "m@m.com";
    String msg = "hello";
    SearchPage searchpageobject;
    ProductDetailsPage productobject;
    EmailFriendPage emailobject;

    @Test(priority = 1 ,enabled = true)
    public void usercanregister()
    {
        homeobject =new HomePage(driver);
        homeobject.openregistrationpage();
        registrationobject =new RegistrationPage(driver);
        registrationobject.UserRegistration("Mohamed","Tawfiq","m77m8777@test.com","12345678");
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
    public void usercanemailfriend()
    {
        productobject.openemailtofriendpage();
        emailobject = new EmailFriendPage(driver);
        emailobject.emailfriend(friendmail,msg);
        Assert.assertTrue(emailobject.resultmsg.getText().contains("Your message has been sent."));
    }

    @Test(priority = 4)
    public void usercanlogout()
    {
        registrationobject.UserLogout();
    }
}