

package TestCaseClasses;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;

import ObjectClasses.Enquiry;
import ObjectClasses.SetupDriver;

public class EnquiryTest extends SetupDriver{

    String enquiryNumber;

    @Test(priority = 18, groups = {"admin", "enquiry"})
    public void addEnquiryTest() {
        System.out.println("\n\n|| ENQUIRY ||\n");

        Enquiry enquiry = new Enquiry(driver);
        enquiry.openNewTab();
        enquiry.addEnquiry("john", "john@gmail.com", "1594826370", "Awesome Art!");
        
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept(); 

        enquiry.closeNewTab();
        enquiryNumber = alertMsg.split("is")[1].strip();
        assertEquals("Your enquiry successfully send. Your Enquiry number", alertMsg.split("is")[0].strip());
    }
    
    @Test(priority = 19, groups = {"admin", "enquiry"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void unansweredEnquiryTest() {
        Enquiry enquiry = new Enquiry(driver);
        enquiry.unansweredEnquiry();

        Alert alert = driver.switchTo().alert();
        alert.accept(); 

        assertTrue(!enquiry.getRemarkDate().isBlank());
    }
    
    @Test(priority = 20, groups = {"admin", "enquiry"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void answeredEnquiryTest() {
        Enquiry enquiry = new Enquiry(driver);
        enquiry.answeredEnquiry();

        System.out.println("\nAnswered Enquiry Details \n");
        enquiry.printEnquiryDetails();
        
        assertEquals(enquiryNumber, enquiry.getEnquiryNumber());
    }
}
