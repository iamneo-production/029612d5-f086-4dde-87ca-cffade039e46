package TestCaseClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.ArtMedium;
import ObjectClasses.ArtProduct;
import ObjectClasses.ArtType;
import ObjectClasses.Artist;
import ObjectClasses.Enquiry;
import ObjectClasses.SetupDriver;

public class DashboardDetailsTest extends SetupDriver{

    
    @BeforeClass(alwaysRun=true)
    public void dashboard() {
        System.out.println("\n\n|| ADMIN DASHBOARD ||");
    }
    
    @Test(priority = 0, groups = {"admin", "dashboard"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void artistDetails() {
        // login.adminLogin();
        Artist artist = new Artist(driver);

        List<List<WebElement>> data = artist.dashboardDetails();

        //  Assert.assertEquals(3, data.size());
        String title = driver.getTitle();
        Assert.assertEquals("Manage Artist | Art Gallery Management System", title);
        
        System.out.println("\nArtist Details!");
        artist.printTable();
    }

    @Test(priority = 1 , groups = {"admin", "dashboard"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void artTypeDetails() {
        // login.adminLogin();
        ArtType artType = new ArtType(driver);

        List<List<WebElement>> data = artType.dashboardDetails();

        //  Assert.assertEquals(8, data.size());
        String title = driver.getTitle();
        Assert.assertEquals("Manage Art Type| Art Gallery Management System", title);
        
        System.out.println("\nArtType Details!");
        artType.printTable();
    }

    @Test(priority = 2 , groups = {"admin", "dashboard"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void artMediumDetails() {
        // login.adminLogin();
        ArtMedium artMedium = new ArtMedium(driver);

        List<List<WebElement>> data = artMedium.dashboardDetails();

        //  Assert.assertEquals(11, data.size());
        String title = driver.getTitle();
        Assert.assertEquals("Manage Art Medium| Art Gallery Management System", title);
        
        System.out.println("\nArt Medium Details!");
        artMedium.printTable();
    }

    @Test(priority = 3 , groups = {"admin", "dashboard"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void artProductDetails() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        List<List<WebElement>> data = artProduct.dashboardDetails();

        //  Assert.assertEquals(3, data.size());
        String title = driver.getTitle();
        Assert.assertEquals("Manage Art Product| Art Gallery Management System", title);
        
        System.out.println("\nArt Product Details!");
        artProduct.printTable();
    }

    @Test(priority = 4 , groups = {"admin", "dashboard"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void AnsweredEnquiryDetails() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.AnsweredEnquiryDetails();

        //  Assert.assertEquals(62, data.size());
        String title = driver.getTitle();
        Assert.assertEquals("Answer Enquiry | Art Gallery Management System", title);
        
        System.out.println("\nAnswered Enquiry Details!");
        enquiry.printTable();
    }

    @Test(priority = 5,groups = {"admin", "dashboard"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void UnansweredEnquiryDetails() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.UnansweredEnquiryDetails();

        //  Assert.assertEquals(26, data.size());
        String title = driver.getTitle();
        Assert.assertEquals("Unanswer Enquiry | Art Gallery Management System", title);
        
        System.out.println("\nUnanswered Enquiry Details!");
        enquiry.printTable();
    }

    @AfterMethod(alwaysRun=true)
    public void driverNavigateBackward() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[1]/a")).click();
    }

}

