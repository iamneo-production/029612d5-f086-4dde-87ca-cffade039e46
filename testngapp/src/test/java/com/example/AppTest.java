package com.example;

import static org.junit.Assert.assertTrue;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;



public class AppTest 
{
    WebDriver driver;
    
    @BeforeMethod
    public void setupDriver() throws Exception {
        System.out.println("Aditya");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

        // Added Implicit wait for 10 seconds // Code changed by Venkatesh(Iamneo)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }   

    @Test
    public void test01()
    {
        try {
            driver.get("https://artgallery.neohire.io/");
            System.out.println(driver.getTitle());
            driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[5]/a")).click();
            driver.findElement(By.xpath("/html/body/div/form/div/div[1]/input")).sendKeys("admin");
            driver.findElement(By.xpath("/html/body/div/form/div/div[2]/input")).sendKeys("Test@123");
            driver.findElement(By.xpath("/html/body/div/form/div/lable/button")).click();
            System.out.println(driver.getTitle());
        String title = driver.getTitle();
        assertEquals("Art Gallery Management System - Admin Dashboard", title);
        // System.out.println("Done");

        } catch (Exception e) {
            System.out.println(e);
        //    driver.quit();
        }
        assertTrue( true );
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}