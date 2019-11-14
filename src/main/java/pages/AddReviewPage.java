package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {
    public AddReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewtilte;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement revuewtxt;

    @FindBy(id = "addproductrating_4")
    WebElement rating;

    @FindBy(css = "input.button-1:nth-child(1)")
    WebElement submitreviewbtn;

    @FindBy(css = "div.result")
    public  WebElement cnfmsg;

    public void addreview (String title , String txt)
    {
        sendtext(reviewtilte , title);
        sendtext(revuewtxt , txt);
        clickbutton(rating);
        clickbutton(submitreviewbtn);
    }
}
