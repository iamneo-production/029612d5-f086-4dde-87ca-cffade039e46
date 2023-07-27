package TestCaseClasses;

import ObjectClasses.SetupDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ObjectClasses.userDropdown;

public class userDropdownTest extends SetupDriver {

    @BeforeClass(alwaysRun=true)
    public void userDropdown() {
        System.out.println("\n\n|| USER DROPDOWN ||");
    }

    @Test(priority = 34, groups = {"user", "regression"})
    public void dropdown()
    {
        test.assignCategory("User");
        userDropdown uDropdown = new userDropdown(driver);
        int expecteddropdownsize = uDropdown.dropdownsize();
        int actualdropdownsize =  uDropdown.dropdown();
        Assert.assertEquals(expecteddropdownsize , actualdropdownsize);
    }
}
