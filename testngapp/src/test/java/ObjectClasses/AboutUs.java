package ObjectClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUs {
    WebDriver driver;

    public AboutUs(WebDriver driver)
    {
        this.driver=driver;
    }

    public void navigateToPages() {
        WebElement pages = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/a"));
        click(pages);
    }
    
    public void submenuElements() {
        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/ul"));
        WebElement element = menu.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[8]/ul/li[1]/a"));

        System.out.println(element.getText());
    }

    public void pageSubmenu() {
        navigateToPages();
        submenuElements();
    }
    
    public void navigateToAboutUsPage() {
        WebElement aboutuspage = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/ul/li[1]/a"));
        click(aboutuspage);
    }
    
    public void fillPageTitle(String title) {
        System.out.println("Updated title for about us: "+title);

        driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div/section/div/div/form/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div/section/div/div/form/div[1]/div/input")).sendKeys(title);
    }

    public void fillPageDescription(String description) {
        System.out.println("Updated description for about us: "+description);
        driver.findElement(By.xpath("//*[@id='pagedes']")).clear();
        driver.findElement(By.xpath("//*[@id='pagedes']")).sendKeys(description);
    }
    
    public void clickUpdateButton() {
        driver.findElement(By.name("submit")).isEnabled();
        WebElement submit = driver.findElement(By.name("submit"));
        click(submit);
    }

    public void checkAboutUs(String usertitle, String userdescription){

        System.out.println("Checking information at user side...");

        ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("http://artgallery.neohire.io/");

            WebElement navAbout=driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[2]/a"));
            click(navAbout);

            String useraboutuspagetitle = driver.findElement(By.xpath("/html/body/section/div/h3")).getText();
            System.out.println("User side Title: " + useraboutuspagetitle);

            String useraboutuspagedesciption = driver.findElement(By.xpath("/html/body/section/div/div[1]/p")).getText();
            System.out.println("User side Description: " + useraboutuspagedesciption);

            boolean booleanTitle= useraboutuspagetitle.equals(usertitle);
            boolean booleanDescription = useraboutuspagedesciption.equals(userdescription);

            boolean verified = booleanTitle && booleanDescription;

            if(verified){
                System.out.println("Verified: User side updated properly for About Us.");
            }else{
                System.out.println("Incorrect information for About Us.");
            }

            driver.close();
            driver.switchTo().window(tabs.get(0));
    }

    public void updateAboutUsPage(String title, String description) {
        navigateToPages();
        navigateToAboutUsPage();
        fillPageTitle(title);
        fillPageDescription(description);
        clickUpdateButton();
    }
    
    public void userSideCheckAboutus(String usertitle, String userdescription){        
        checkAboutUs(usertitle,userdescription);
    }
    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
}
