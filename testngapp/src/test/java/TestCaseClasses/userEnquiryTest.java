package TestCaseClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userEnquiry;

public class userEnquiryTest extends SetupDriver {
    @BeforeClass(alwaysRun = true)
    public void userEnquiry() {
        System.out.println("\n\n|| USER ENQUIRY ||");
    }

    @Test(priority = 35, groups = {"user"})
    public void enquiry()
    {
        test.assignCategory("User");
        userEnquiry uEnquiry = new userEnquiry(driver);

        int expectedenquirybuttons= uEnquiry.enquirybuttoncount();
        int actualenquirybuttons = uEnquiry.enquirybutton();

        Assert.assertEquals(expectedenquirybuttons, actualenquirybuttons);
    }
}
