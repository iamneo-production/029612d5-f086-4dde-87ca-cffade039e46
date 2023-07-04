package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.Enquiry;
import ObjectClasses.SetupDriver;

public class EnquirySearchTest extends SetupDriver{
    
    static String sName;
    static String sEnquiryNumber;
    static String sMobileNumber;
    
    @BeforeClass
    public void fetchData() {
        System.out.println("\n\n|| ENQUIRY SEARCH ||\n");
        Enquiry enquiry = new Enquiry(driver);
        String[] searchData = enquiry.fetchSearchData().split(" ");
        sEnquiryNumber = searchData[1];
        sName = searchData[2];
        sMobileNumber = searchData[3];
    }

    @Test(priority = 0)
    public void enquirySearchByNameTest() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.enquirySearch(sName);
        assertEquals(sName, data.get(0).get(2).getText());
        System.out.println("\nEnquiry Search By Name : " + sName);
        enquiry.printTable();
    }
    
    @Test(priority = 1)
    public void enquirySearchByEnquiryNumberTest() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.enquirySearch(sEnquiryNumber);
        
        assertEquals(sEnquiryNumber, data.get(0).get(1).getText());
        System.out.println("\nEnquiry Search By Number : " + sEnquiryNumber);
        enquiry.printTable();
    }
    
    @Test(priority = 2)
    public void enquirySearchByMobileNumberTest() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.enquirySearch(sMobileNumber);

        assertEquals(sMobileNumber, data.get(0).get(3).getText());
        System.out.println("\nEnquiry Search By Mobile Number : " + sMobileNumber);
        enquiry.printTable();
    }
}
