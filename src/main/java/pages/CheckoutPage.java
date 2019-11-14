package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipcode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phone;

    @FindBy(css = "input.new-address-next-step-button:nth-child(1)")
    WebElement continuebtn;

    @FindBy(css = ".shipping-method-next-step-button")
    WebElement continuebtn2;

    @FindBy(css = ".payment-method-next-step-button")
    WebElement continuebtn3;

    @FindBy(css = ".payment-info-next-step-button")
    WebElement continuebtn4;

    @FindBy(css = ".confirm-order-next-step-button")
    WebElement confirmbtn;

    @FindBy(css = ".section > div:nth-child(1) > strong:nth-child(1)")
    public WebElement confirmmsg;

    @FindBy(linkText = "Click here for order details.")
    WebElement opendetailsbtn;

    @FindBy(css = "input.button-1:nth-child(1)")
    WebElement endcheckout;

    public void confirmcheckout(String countryname , String cityname , String addressname , String postalcode , String phonemumber)
    {
        sendtext(country , countryname);
        sendtext(city , cityname);
        sendtext(address , addressname);
        sendtext(zipcode , postalcode);
        sendtext(phone , phonemumber);
        clickbutton(continuebtn);
        clickbutton(continuebtn2);
        clickbutton(continuebtn3);
        clickbutton(continuebtn4);
        clickbutton(confirmbtn);
    }

    public void opendetailspage()
    {
        clickbutton(opendetailsbtn);
    }

    public void endcheckout()
    {
        clickbutton(endcheckout);
    }

}
