package ObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userNavbar {
    WebDriver driver;

    public userNavbar(WebDriver driver)
    {
        this.driver=driver;
    }

    public void home() 
    {
        WebElement navHome = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[1]/a"));
        click(navHome);
        System.out.println("Home");
    }

    public void about()
    {
        WebElement navAbout=driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[2]/a"));
        click(navAbout);
        System.out.println("About Us");

    }

    public void arttype()
    {
       WebElement navArttype=driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]"));
       click(navArttype);
       System.out.println("Art Type:- ");

    }

    public void contactus()
    {
        WebElement navContactus=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a"));
        click(navContactus);
        System.out.println("Contact Us");

    }

    public void admin()
    {
        WebElement navAdmin=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a"));
        click(navAdmin);
        System.out.println("Admin");

    }
    
    public void homepage()
    {
        driver.navigate().to("https://artgallery.neohire.io/");
    }

    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
}
