package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".current-item")
    public WebElement productnameindirectory;

    @FindBy(css = ".email-a-friend-button")
    WebElement emailfriendlink;

    @FindBy(css = ".price-value-4")
    public  WebElement productprice;

    @FindBy(linkText = "Add your review")
    WebElement addreviewlink;

    @FindBy(id = "add-to-wishlist-button-8")
    WebElement addtowishlistbtn;

    @FindBy(css = ".content")
    public WebElement confirmaddmsg;

    @FindBy(linkText = "wishlist")
    WebElement wishlistlink;

    @FindBy(css = ".compare-products > input:nth-child(1)")
    WebElement addtocomparelistbtn;

    @FindBy(linkText = "product comparison")
    WebElement comparelistlink;

    @FindBy(css = ".content")
    public WebElement confirmaddtocomparemsg;

    @FindBy(id = "add-to-cart-button-8")
    WebElement addtocartbtn;

    @FindBy(css = ".content")
    public WebElement addtocartmsg;

    @FindBy(linkText = "shopping cart")
    WebElement cartlink;

    public void openemailtofriendpage()
    {
        clickbutton(emailfriendlink);
    }

    public void addreview()
    {
        clickbutton(addreviewlink);
    }

    public void addtowishlist()
    {
        clickbutton(addtowishlistbtn);
    }

    public void openwishlist()
    {
        clickbutton(wishlistlink);
    }

    public void addtocomparelist()
    {
        clickbutton(addtocomparelistbtn);
    }

    public void opencomparelist()
    {
        clickbutton(comparelistlink);
    }

    public void addtocart()
    {
        clickbutton(addtocartbtn);
    }

    public void opencartpage()
    {
        clickbutton(cartlink);
    }

}
