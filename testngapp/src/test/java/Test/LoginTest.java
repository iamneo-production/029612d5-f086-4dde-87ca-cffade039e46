package Test;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import Pages.Login;
import Pages.SetupDriver;

public class LoginTest {
    WebDriver driver;
    Login login;
    
    @BeforeMethod
    public void setupDriver() {
        try {
            driver = SetupDriver.setup();
        } catch (Exception e) {
            System.out.println(e);
        }
        login = new Login(driver);

    }

    @Test
    public void AdminLoginWithValidDetails() {
        System.out.println("up");
        login.adminLogin();
        
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("down");

        login.navigateToAdminLogoutPage();
        assertEquals("Art Gallery Management System - Admin Dashboard", title);
    }

    //@Test
    public void AdminLoginWithInValidDetails() {
        login.adminLogin("abc", "xyz"); 
        Alert alert = driver.switchTo().alert();
        
        login.backToHomepage();
        assertEquals("Invalid Details", alert.getText());
    }

    //@Test
    public void AdminLoginWithInValidDetailsusername() {
        login.adminLogin("abc", "Test@123"); 
        Alert alert = driver.switchTo().alert();
        login.backToHomepage();
        
        assertEquals("Invalid Details", alert.getText());
    }

    //@Test
    public void AdminLoginWithInValidDetailspassword() {
        login.adminLogin("admin", "xyz"); 
        Alert alert = driver.switchTo().alert();
        login.backToHomepage();
        
        assertEquals("Invalid Details", alert.getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
