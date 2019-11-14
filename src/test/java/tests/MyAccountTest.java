package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.MyAccountpage;
import pages.RegistrationPage;

public class MyAccountTest extends TestBase {

    HomePage homeobject;
    RegistrationPage registrationobject;
    MyAccountpage myaccountobject;
    LogInPage loginpageobject;

    String oldpassword ="12345678";
    String newpassword = "123456";
    String email = "m1234444554@m.com";

    @Test(priority = 1 ,enabled = true)
    public void usercanregister()
    {
        homeobject = new HomePage(driver);
        homeobject.openregistrationpage();
        registrationobject = new RegistrationPage(driver);
        registrationobject.UserRegistration("Mohamed" , "Esam" , email ,oldpassword);
        Assert.assertTrue(registrationobject.confrimmassege.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void usercanchangepassword()
    {
        myaccountobject = new MyAccountpage(driver);
        registrationobject.Useracciuntpage();
        myaccountobject.openchangepasswordlink();
        myaccountobject.changepassword(oldpassword,newpassword);
        Assert.assertTrue(myaccountobject.resultlabel.getText().contains("Password was changed"));
    }

    @Test(priority = 3)
    public void usercanlogout()
    {
        registrationobject.UserLogout();
    }

    @Test(priority = 4)
    public void registeredusercanlogin()
    {
        homeobject.openloginpage();
        loginpageobject = new LogInPage(driver);
        loginpageobject.userlogin(email , newpassword);
    }
}
