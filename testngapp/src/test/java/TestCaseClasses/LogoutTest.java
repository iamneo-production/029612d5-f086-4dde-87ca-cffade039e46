package TestCaseClasses;

import org.testng.annotations.Test;
import org.testng.Assert;
import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class LogoutTest extends SetupDriver{
    
    @Test(priority = 28, groups = {"logout"})
    public void AdminLogout() {
        Login login = new Login(driver);
        login.adminLogout();

        String title = driver.getTitle();
        Assert.assertEquals("Login| Art Gallery Management System", title);

        login.navigateBackToHomePage();
    }
}
