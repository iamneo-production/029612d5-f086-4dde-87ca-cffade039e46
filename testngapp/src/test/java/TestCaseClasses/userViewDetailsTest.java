package TestCaseClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userViewDetails;

public class userViewDetailsTest extends SetupDriver {

    @BeforeClass(alwaysRun = true)
    public void userViewDetails() {
        System.out.println("\n\n|| USER VIEW DETAILS ||");
    }
    
    @Test(priority = 37, groups = {"user", "regression"})
    public void search()
    {
        userViewDetails uDetails = new userViewDetails(driver);
        uDetails.viewDetails();
    }
}
