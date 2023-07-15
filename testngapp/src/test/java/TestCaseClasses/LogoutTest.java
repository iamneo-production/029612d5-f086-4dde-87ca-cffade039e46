package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class LogoutTest extends SetupDriver{
    
    @Test(priority = 28, groups = {"logout"})
    public void AdminLogout() {
        Login login = new Login(driver);
        login.adminLogout();

        String title = driver.getTitle();
        assertEquals("Login| Art Gallery Management System", title);

        login.navigateBackToHomePage();
    }
}
