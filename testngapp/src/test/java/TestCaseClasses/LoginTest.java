package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import ObjectClasses.Login;
import ObjectClasses.SetupDriver;
import org.testng.annotations.BeforeClass;


public class LoginTest extends SetupDriver{
    @BeforeClass(alwaysRun=true)
    public void artType() {
        System.out.println("\n\n|| LOGIN ||");
    }

    @Test(groups = {"login"}, dependsOnMethods = {"AdminLoginWithInValidDetails"})    
    public void AdminLoginWithValidDetails() {
        Login login = new Login(driver);
        login.adminLogin();
        String title = driver.getTitle();
        
        assertEquals("Art Gallery Management System - Admin Dashboard", title);
        System.out.println("\n Valid Login Details Check");
    }
    
    @Test( groups = {"login"})
    public void AdminLoginWithInValidDetails() {
        Login login = new Login(driver);
        login.navigateToAdminLoginPage();

        login.adminLogin("abc", "xyz"); 
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();

        // login.navigateBackToHomePage();
        assertEquals("Invalid Details", alertMsg);
        System.out.println("\n Invalid Login Details Check");
    }

}
