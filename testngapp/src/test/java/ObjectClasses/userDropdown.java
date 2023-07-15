package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userDropdown {
    WebDriver driver;
    public userDropdown(WebDriver driver)
    {
        this.driver=driver;
    }

    public int dropdownsize(){
        WebElement navbarDropdown = driver.findElement(By.id("navbarDropdown1"));
        click(navbarDropdown);
        List<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/div/a"));
        int dropdownsize = options.size(); 
        return dropdownsize;  
    }
    
    public int dropdown()
    {
        WebElement navbarDropdown = driver.findElement(By.id("navbarDropdown1"));
        click(navbarDropdown);
        
        List<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/div/a"));
        int dropdowncount = 0;
        for (WebElement element : options) {

            String link = element.getAttribute("href");
            String text = element.getAttribute("textContent");

            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get(link);

            String headline=driver.findElement(By.xpath("/html/body/section/div/h2")).getText();
            System.out.println("Option name: "+text);
            System.out.println("Page title: " +headline);
            System.out.println("\n");
            
            driver.close();
            driver.switchTo().window(tabs.get(0));

            dropdowncount++;
        }
        return dropdowncount;
    }

    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
}
