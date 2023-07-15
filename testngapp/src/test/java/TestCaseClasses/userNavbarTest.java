package TestCaseClasses;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userNavbar;

public class userNavbarTest extends SetupDriver {

    @BeforeClass(alwaysRun = true)
    public void artType() {
        System.out.println("\n\n|| USER NAVBAR ||");
    }

    @Test(priority = 29, groups = {"user", "regression"})
    public void home()
    {
        userNavbar uNavbar = new userNavbar(driver);
        uNavbar.home();
        String title=driver.getTitle();
        assertEquals("Art Gallery Management System | Home Page",title);
    }

    @Test(priority = 30, groups = {"user", "regression"})
    public void about()
    {
        userNavbar uNavbar = new userNavbar(driver);
        uNavbar.about();
        String title=driver.getTitle();
        assertEquals("Art Gallery Management System | About Us Page",title);
    }

    @Test(priority = 31, groups = {"user", "regression"})
    public void arttype()
    {
        userNavbar uNavbar = new userNavbar(driver);
        uNavbar.arttype();
        List<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/div/a"));
        int size=options.size();
        int count=0;
        for (WebElement element : options) {
            String text = element.getAttribute("textContent");
            System.out.println("Option name: " + text);
            count++;
        }
        assertEquals(size,count);
    }

    @Test(priority = 32, groups = {"user", "regression"})
    public void contactus()
    {
        userNavbar uNavbar = new userNavbar(driver);
        uNavbar.contactus();
        String title=driver.getTitle();
        assertEquals("Art Gallery Management System | Contact Us Page",title);
    }

    @Test(priority = 33, groups = {"user", "regression"})
    public void admin()
    {
        userNavbar uNavbar = new userNavbar(driver);
        uNavbar.admin();
        String title=driver.getTitle();
        assertEquals("Login| Art Gallery Management System",title);
        uNavbar.homepage();
    }
    
}