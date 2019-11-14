package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement fullname;

    @FindBy(id = "Email")
    WebElement emial;

    @FindBy(id = "Enquiry")
    WebElement message;

    @FindBy(css = "input.button-1:nth-child(1)")
    WebElement submitbtn;

    @FindBy(css = ".result")
    public WebElement confrimmsg;

    public void contactus (String username ,String usermail , String usermessage)
    {
        sendtext(fullname,username);
        sendtext(emial,usermail);
        sendtext(message,usermessage);
        clickbutton(submitbtn);
    }
}
