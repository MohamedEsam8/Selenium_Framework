package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.RegistrationPage;


public class RegistrationTest extends TestBase
{
    HomePage homeobject;
    RegistrationPage registrationobject;
    LogInPage loginobject;

    @Test(priority = 1 ,alwaysRun = true)
    public void usercanregister()
    {

        homeobject =new HomePage(driver);
        homeobject.openregistrationpage();
        registrationobject =new RegistrationPage(driver);
        registrationobject.UserRegistration("Mohamed","Tawfiq","m7m7m8m9m0000@test.com","12345678");
        Assert.assertTrue(registrationobject.confrimmassege.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = "usercanregister")
    public void usercanlogout()
    {
        registrationobject.UserLogout();
    }

    @Test(dependsOnMethods = "usercanlogout")
    public void  usercanlogin()
    {
        homeobject.openloginpage();
        loginobject = new LogInPage(driver);
        loginobject.userlogin("mnm888@test.com","12345678");
    }

}
