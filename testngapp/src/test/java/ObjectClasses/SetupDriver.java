package ObjectClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.MyTestListener;

@Listeners(MyTestListener.class)
public class SetupDriver {
    public static WebDriver driver=null;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public static void setup() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        driver.get("https://artgallery.neohire.io/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extent = ExtentManager.getInstance();
        System.out.println("\n\n || TESTSUITE STARTED ||");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("\n\n || TESTSUITE TERMINATED || \n\n");
        extent.flush();
        driver.quit();
    }
}