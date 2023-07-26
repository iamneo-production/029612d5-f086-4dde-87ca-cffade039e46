

package TestCaseClasses;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.Alert;

import ObjectClasses.Enquiry;
import ObjectClasses.SetupDriver;

public class EnquiryTest extends SetupDriver{

    public static String enquiryNumber;

    @Test(priority = 18, groups = {"admin", "enquiry"})
    public void addEnquiryTest() {
        System.out.println("\n\n|| ENQUIRY ||\n");

        Enquiry enquiry = new Enquiry(driver);
        enquiry.openNewTab();
        enquiry.addEnquiry("max", "max@gmail.com", "8444465644", "Awesome Art!");
        
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept(); 

        enquiry.closeNewTab();
        enquiryNumber = alertMsg.split("is")[1].strip();
        Assert.assertEquals("Your enquiry successfully send. Your Enquiry number", alertMsg.split("is")[0].strip());
    }
    
    @Test(priority = 19, groups = {"admin", "enquiry"}, dependsOnMethods = {"AdminLoginWithValidDetails", "addEnquiryTest"})
    public void unansweredEnquiryTest() {
        Enquiry enquiry = new Enquiry(driver);
        enquiry.unansweredEnquiry(enquiryNumber); 

        Alert alert = driver.switchTo().alert();
        alert.accept(); 

        Assert.assertTrue(!enquiry.getRemarkDate().isBlank());
    }
    
    @Test(priority = 20, groups = {"admin", "enquiry"}, dependsOnMethods = {"AdminLoginWithValidDetails", "addEnquiryTest"})
    public void answeredEnquiryTest() {
        Enquiry enquiry = new Enquiry(driver);
        enquiry.answeredEnquiry(enquiryNumber);

        System.out.println("\nAnswered Enquiry Details \n");
        enquiry.printEnquiryDetails();
        
        Assert.assertEquals(enquiryNumber, enquiry.getEnquiryNumber());
    }
}
