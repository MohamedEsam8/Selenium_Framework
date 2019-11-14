package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareListPage extends PageBase {
    public CompareListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tr.specification:nth-child(6) > td:nth-child(2)")
    public WebElement cpu1;

    @FindBy(css = "tr.specification:nth-child(6) > td:nth-child(3)")
    public WebElement cpu2;

    @FindBy(css = ".remove-product > td:nth-child(3) > input:nth-child(1)")
    WebElement remove1btn;

    @FindBy(css = ".remove-product > td:nth-child(2) > input:nth-child(1)")
    WebElement remove2btn;

    @FindBy(css =".no-data")
    public WebElement confirmremovemsg;

    @FindBy(css = ".compare-products-table")
    WebElement table;

    List<WebElement> rows = table.findElements(By.tagName("tr"));

    public void listallproductdetails()
    {
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement coulmn : columns) {
                System.out.print(coulmn.getText());
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void removeproducts()
    {
        clickbutton(remove1btn);
        clickbutton(remove2btn);
    }
}
