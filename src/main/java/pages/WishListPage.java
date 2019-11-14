package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "HP Envy 6-1180ca 15.6-Inch Sleekbook")
    public WebElement productnm;

    @FindBy(css = "td.remove-from-cart > input:nth-child(2)")
    WebElement removebtn;

    @FindBy(css = "input.button-2:nth-child(1)")
    WebElement updatewishlist;

    @FindBy(css = ".no-data")
    public WebElement upadtemsg;

    public void removeproduct()
    {
        clickbutton(removebtn);
    }

    public void updatewishlist()
    {
        clickbutton(updatewishlist);
    }
}
