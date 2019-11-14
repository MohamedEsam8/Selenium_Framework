package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement firendemeailtxtbox;

    @FindBy(id = "PersonalMessage")
    WebElement personalmsgtxtbox;

    @FindBy(css = "input.button-1:nth-child(1)")
    WebElement sendmailbtn;

    @FindBy(css = ".result")
    public WebElement resultmsg;

    public void emailfriend(String friendmail , String personalmsg)
    {
        sendtext(firendemeailtxtbox , friendmail);
        sendtext(personalmsgtxtbox , personalmsg);
        clickbutton(sendmailbtn);
    }
}
