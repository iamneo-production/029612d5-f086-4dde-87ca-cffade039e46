package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ObjectClasses.SetupDriver;
import ObjectClasses.userSearch;

public class userSearchTest extends SetupDriver {
    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| USER SEARCH ||");
    }

    @Test(priority = 0)
    public void search()
    {
        userSearch uSearch = new userSearch(driver);
        uSearch.search("A");
    }

    @AfterClass
    public void artTypeend() {
        System.out.println("\n\n||| TEST SUITE ENDED |||");
    }   
}
