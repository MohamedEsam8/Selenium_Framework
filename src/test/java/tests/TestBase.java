package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public static WebDriver driver;

    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.download.dir", downloadPath);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        option.addPreference("pdf.disabled", true);
        return option;
    }

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }


    @BeforeTest
    @Parameters({"browser"})
    public void startdriver(@Optional("chrome") String browsername)
    {
        if (browsername.equalsIgnoreCase("chrome")) {
            String chromepath = (System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromepath);
            driver = new ChromeDriver(chromeOption());
        }
        else if (browsername.equalsIgnoreCase("firefox")) {
            String foxpath = (System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", foxpath);
            driver = new FirefoxDriver(firefoxOption());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120 , TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void stopdriver()
    {
       driver.quit();
    }

    @AfterMethod
    public void takescreenshotonfail (ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Test case failed");
            System.out.println("Taking Screenshot .......");
            helper.Help.takescreenshot(driver,result.getName());
        }
    }

}
