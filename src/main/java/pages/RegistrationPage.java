package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase
{
    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement malerdbtn;

    @FindBy(id = "gender-female")
    WebElement femalerdbtn;

    @FindBy(id = "FirstName")
    WebElement firstnametxtbox;

    @FindBy(id = "LastName")
    WebElement lastnametxtbox;

    @FindBy(id = "Email")
    WebElement emailtxtbox;

    @FindBy(id = "Password")
    WebElement passwordtxtbox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmpasswordtxtbox;

    @FindBy(id = "register-button")
    WebElement registerbtn;

    @FindBy(css = "div.result")
    public WebElement confrimmassege;

    @FindBy(linkText = "Log out")
    WebElement logoutbtn;

    @FindBy(linkText = "My account")
    WebElement myaccountlink;

    public void UserRegistration(String firstname , String lastname , String email , String password)
    {
        clickbutton(malerdbtn);
        sendtext(firstnametxtbox,firstname);
        sendtext(lastnametxtbox,lastname);
        sendtext(emailtxtbox,email);
        sendtext(passwordtxtbox,password);
        sendtext(confirmpasswordtxtbox,password);
        clickbutton(registerbtn);
    }

    public void UserLogout()
    {
        clickbutton(logoutbtn);
    }

    public void Useracciuntpage()
    {
        clickbutton(myaccountlink);
    }
}
