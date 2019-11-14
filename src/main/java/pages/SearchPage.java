package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement sreachtxtbox;

    @FindBy(css = ".search-box-button")
    WebElement seachbtn;

    @FindBy (css = "#ui-id-1")
    List<WebElement> productlist;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productlink;

    public void seachforproduct(String productname)
    {
        sendtext(sreachtxtbox ,productname);
        clickbutton(seachbtn);
    }

    public void openproductdetailspage()
    {
        clickbutton(productlink);
    }

    public void seachproductbyautocomplete(String searchtxt)
    {
        sendtext(sreachtxtbox,searchtxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productlist.get(0).click();
    }
}
