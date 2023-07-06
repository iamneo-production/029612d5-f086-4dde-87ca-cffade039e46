package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.ArtMedium;
import ObjectClasses.ArtProduct;
// import ObjectClasses.ArtType;
// import ObjectClasses.Artist;
// import ObjectClasses.Enquiry;
import ObjectClasses.SetupDriver;

public class DashboardDetailsTest extends SetupDriver{

    
    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| ADMIN DASHBOARD ||");
    }
    
    // @Test(priority = 0)
    // public void artistDetails() {
    //     // login.adminLogin();
    //     Artist artist = new Artist(driver);

    //     List<List<WebElement>> data = artist.dashboardDetails();

    //     // assertEquals(3, data.size());
    //     String title = driver.getTitle();
    //     assertEquals("Manage Artist | Art Gallery Management System", title);
        
    //     System.out.println("\nArtist Details!");
    //     artist.printTable();
    // }

    // @Test(priority = 1)
    // public void artTypeDetails() {
    //     // login.adminLogin();
    //     ArtType artType = new ArtType(driver);

    //     List<List<WebElement>> data = artType.dashboardDetails();

    //     // assertEquals(8, data.size());
    //     String title = driver.getTitle();
    //     assertEquals("Manage Art Type| Art Gallery Management System", title);
        
    //     System.out.println("\nArtType Details!");
    //     artType.printTable();
    // }

    @Test(priority = 2)
    public void artMediumDetails() {
        // login.adminLogin();
        ArtMedium artMedium = new ArtMedium(driver);

        List<List<WebElement>> data = artMedium.dashboardDetails();

        // assertEquals(11, data.size());
        String title = driver.getTitle();
        assertEquals("Manage Art Medium| Art Gallery Management System", title);
        
        System.out.println("\nArt Medium Details!");
        artMedium.printTable();
    }

    @Test(priority = 3)
    public void artProductDetails() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        List<List<WebElement>> data = artProduct.dashboardDetails();

        // assertEquals(3, data.size());
        String title = driver.getTitle();
        assertEquals("Manage Art Product| Art Gallery Management System", title);
        
        System.out.println("\nArt Product Details!");
        artProduct.printTable();
    }

    // @Test(priority = 4)
    // public void AnsweredEnquiryDetails() {
    //     // login.adminLogin();
    //     Enquiry enquiry = new Enquiry(driver);
    //     List<List<WebElement>> data = enquiry.AnsweredEnquiryDetails();

    //     // assertEquals(62, data.size());
    //     String title = driver.getTitle();
    //     assertEquals("Answer Enquiry | Art Gallery Management System", title);
        
    //     System.out.println("\nAnswered Enquiry Details!");
    //     enquiry.printTable();
    // }

    // @Test(priority = 5)
    // public void UnansweredEnquiryDetails() {
    //     // login.adminLogin();
    //     Enquiry enquiry = new Enquiry(driver);
    //     List<List<WebElement>> data = enquiry.UnansweredEnquiryDetails();

    //     // assertEquals(26, data.size());
    //     String title = driver.getTitle();
    //     assertEquals("Unanswer Enquiry | Art Gallery Management System", title);
        
    //     System.out.println("\nUnanswered Enquiry Details!");
    //     enquiry.printTable();
    // }

    @AfterMethod
    public void driverNavigateBackward() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[1]/a")).click();
    }

}

