package ObjectClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userLinks {   
    WebDriver driver;
    
    public userLinks(WebDriver driver)
    {
        this.driver=driver;
    }

    public String linkArtgallery()
    {
        WebElement artgallery = driver.findElement(By.linkText("Art Gallery"));
        click(artgallery);
        String pageTitle = driver.getTitle();
        System.out.println("Art Gallery Logo Link");
        System.out.println("\t Page Title: "+pageTitle +"\n");

        return pageTitle;
    }

    public String linkreadmore()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement readmore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/ul/li[2]/div/div/div/div[2]/a")));
        click(readmore);

        String pageTitle = driver.getTitle();
        System.out.println("Read more Link");
        System.out.println("\t Page Title: "+pageTitle +"\n");        
        
        return pageTitle;
    }

     
    public String linkarrow()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/a")));
        click(arrow);
        
        String pageTitle = driver.getTitle();
        System.out.println("Scroll to top Link");
        System.out.println("\t Page Title: "+pageTitle +"\n");
        return pageTitle;
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
