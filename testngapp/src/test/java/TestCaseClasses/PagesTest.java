package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.AboutUs;
import ObjectClasses.ContactUs;
import ObjectClasses.SetupDriver;


public class PagesTest extends SetupDriver{
    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| ADMIN PAGES ||");
    }

    @Test(priority = 24, groups = {"admin", "pages"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void pagesMenuTestaboutus() {
        System.out.println("\n\nABOUT US\n");
        AboutUs aboutus = new AboutUs(driver);
        aboutus.pageSubmenu();
    }

    @Test(priority = 25, groups = {"admin", "pages"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void updateAboutUsPageTestaboutus() {
        AboutUs aboutus = new AboutUs(driver);
        String title = "About Us";
        String description = "This is Art Gallery Management system where you can buy art products categorised into different art type with the mission to uplift the gig working artist force.";
        aboutus.updateAboutUsPage(title,description);

        Alert alert = driver.switchTo().alert();
        assertEquals("About Us has been updated.", alert.getText());
        alert.accept();
        driver.navigate().to("http://artgallery.neohire.io/admin/dashboard.php");
        aboutus.userSideCheckAboutus(title, description);
    }

    @Test(priority = 26, groups = {"admin", "pages"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void pagesMenuTestcontactus() {
        System.out.println("\n\nCONTACT US\n");
        ContactUs contactus = new ContactUs(driver);
        contactus.pageSubmenu();
    }

    @Test(priority = 27, groups = {"admin", "pages"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void updateContactUsPageTestContactUs() {
        ContactUs contactus = new ContactUs(driver);

        String title = "Contact Us";
        String email = "artgallery@gmail.com";
        String phonenumber = "9988548822";
        String timings = "9:00 am to 6:00 pm";

        String description = "Our art gallery contact service is active within provided timings for more 24/7 service please reach us by provided email id";
       
        contactus.updateContactUsPage(title, email, phonenumber, timings, description);

        Alert alert = driver.switchTo().alert();
        assertEquals("Contact Us has been updated..", alert.getText());
        alert.accept();
        driver.navigate().to("http://artgallery.neohire.io/admin/dashboard.php");
        contactus.userSideCheckContactus(title, email, phonenumber, timings, description);
    }
}
