package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInfoPage extends PageBase {
    public OrderInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.button-2:nth-child(3)")
    WebElement pdfinvoicebtn;

    public void downloadpdf()
    {
        clickbutton(pdfinvoicebtn);
    }
}
