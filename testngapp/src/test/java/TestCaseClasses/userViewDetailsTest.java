package TestCaseClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userViewDetails;

public class userViewDetailsTest extends SetupDriver {

    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| USER VIEW DETAILS ||");
    }
    
    @Test(priority = 0)
    public void search()
    {
        userViewDetails uDetails = new userViewDetails(driver);
        uDetails.viewDetails();
    }
}
