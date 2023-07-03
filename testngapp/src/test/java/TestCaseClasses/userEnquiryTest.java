package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userEnquiry;

public class userEnquiryTest extends SetupDriver {
    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| USER ENQUIRY ||");
    }

    @Test(priority = 0)
    public void dropdown()
    {
        userEnquiry uEnquiry = new userEnquiry(driver);

        int expectedenquirybuttons= uEnquiry.enquirybuttoncount();
        int actualenquirybuttons = uEnquiry.enquirybutton();

        assertEquals(expectedenquirybuttons, actualenquirybuttons);
    }
}
