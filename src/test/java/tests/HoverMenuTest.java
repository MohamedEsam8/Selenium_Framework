package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HoverMenuTest extends TestBase {

    HomePage home;

    @Test
    public void usercanhovermenu()
    {
        home = new HomePage(driver);
        home.hovermenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
