package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends PageBase {
    public MyAccountpage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changepasswordlink;

    @FindBy(id = "OldPassword")
    WebElement oldpasswordtxtbox;

    @FindBy(id = "NewPassword")
    WebElement newpasswordtxtbox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmnewpasswordtxtbox;

    @FindBy(css = "input.button-1:nth-child(1)")
    WebElement changepasswordbtn;

    @FindBy(css = "div.result")
    public WebElement resultlabel;

    public void openchangepasswordlink()
    {
        clickbutton(changepasswordlink);
    }

    public void changepassword(String oldpassword , String newpassword)
    {
        sendtext(oldpasswordtxtbox,oldpassword);
        sendtext(newpasswordtxtbox,newpassword);
        sendtext(confirmnewpasswordtxtbox,newpassword);
        clickbutton(changepasswordbtn);
    }
}
