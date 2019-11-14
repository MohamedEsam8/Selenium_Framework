package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.sql.Driver;

public class HomePage extends PageBase
{
    public HomePage(WebDriver driver)
    {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registrationlink;

    @FindBy(linkText = "Log in")
    WebElement loginlink;

    @FindBy(linkText = "Contact us")
    WebElement contactuslink;

    @FindBy(id = "customerCurrency")
    WebElement currencylist;

    @FindBy(linkText = "Computers")
    WebElement computersmenu;

    @FindBy(linkText = "Notebooks")
    WebElement notbooksubmenu;

    public void openregistrationpage()
    {
        clickbutton(registrationlink);
    }

    public void openloginpage()
    {
        clickbutton(loginlink);
    }

    public void opencontactuspage()
    {
        scrolltobottom();
        clickbutton(contactuslink);
    }

    public void changecurrency()
    {
        select = new Select(currencylist);
        select.selectByVisibleText("Euro");
    }

    public void hovermenu()
    {
        action.moveToElement(computersmenu).moveToElement(notbooksubmenu).click().build().perform();
    }
}
