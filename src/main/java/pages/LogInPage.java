package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends PageBase {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailtxtbox;

    @FindBy(id = "Password")
    WebElement passwordtxtbox;

    @FindBy(css = ".login-button")
    WebElement loginbtn;

    public void userlogin(String email , String password)
    {
        sendtext(emailtxtbox ,email);
        sendtext(passwordtxtbox , password);
        clickbutton(loginbtn);
    }
}
