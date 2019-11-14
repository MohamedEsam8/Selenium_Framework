package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase
{
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;

    public PageBase (WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    protected static void  clickbutton (WebElement button)
    {
        button.click();
    }

    protected static void  cleartxt (WebElement textbox)
    {
        textbox.clear();
    }

    protected static void sendtext (WebElement textbox , String value)
    {
        textbox.sendKeys(value);
    }

    public void scrolltobottom ()
    {
        jse.executeScript("scrollBy(0,2500)");
    }
}
