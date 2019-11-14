package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-unit-price")
    public WebElement productprice;

    @FindBy(className = "qty-input")
    WebElement productquntity;

    @FindBy(css = ".update-cart-button")
    WebElement updatecartbtn;

    @FindBy(css = ".product-subtotal")
    public WebElement updatedprice;

    @FindBy(name = "removefromcart")
    WebElement removeproduct;

    @FindBy(css = ".no-data")
    public WebElement confirmmsg;

    @FindBy(id = "termsofservice")
    WebElement agreebtn;

    @FindBy(id = "checkout")
    WebElement checkoutbtn;

    public void increasequantityandupdate(String quantity)
    {
        cleartxt(productquntity);
        sendtext(productquntity,quantity);
        clickbutton(updatecartbtn);
    }

    public void removeproductandupdate()
    {
        clickbutton(removeproduct);
        clickbutton(updatecartbtn);
    }

    public void openchckoutpage()
    {
        clickbutton(agreebtn);
        clickbutton(checkoutbtn);
    }
}
