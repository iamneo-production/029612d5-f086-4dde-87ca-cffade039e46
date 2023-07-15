package TestCaseClasses;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import ObjectClasses.SetupDriver;
import ObjectClasses.userSearch;

public class userSearchTest extends SetupDriver {
    @BeforeClass(alwaysRun = true)
    public void artType() {
        System.out.println("\n\n|| USER SEARCH ||");
    }

    @Test(priority = 38, groups = {"user"})
    public void search()
    {
        userSearch uSearch = new userSearch(driver);
        uSearch.search("A");
    }
}
