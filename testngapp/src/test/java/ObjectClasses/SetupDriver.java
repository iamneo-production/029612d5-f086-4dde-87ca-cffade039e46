package ObjectClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class SetupDriver {
    public static WebDriver driver=null;

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
        System.out.println("\n\n || TESTSUITE STARTED ||");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("\n\n || TESTSUITE TERMINATED || \n\n");
        driver.quit();
    }
}