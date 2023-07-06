package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class LoginTest extends SetupDriver{
    
    @Test(priority = 1)
    public void AdminLoginWithValidDetails() {
        Login login = new Login(driver);
        login.adminLogin();
        String title = driver.getTitle();
        
        assertEquals("Art Gallery Management System - Admin Dashboard", title);
        System.out.println("\n Valid Login Details Check");
    }
    
    @Test(priority = 0)
    public void AdminLoginWithInValidDetails() {
        System.out.println("\n\n|| LOGIN ||");
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
