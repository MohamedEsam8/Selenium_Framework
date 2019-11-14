package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

    HomePage home;
    ContactUsPage contact;

    String fullname = "Mohamed";
    String email = "m@m.com";
    String message = "hi all";

    @Test
    public void usercanopencontactuspage()
    {
        home = new HomePage(driver);
        contact = new ContactUsPage(driver);
        home.opencontactuspage();
        contact.contactus(fullname,email,message);
        Assert.assertTrue(contact.confrimmsg.getText().equals("Your enquiry has been successfully sent to the store owner."));
    }
}
