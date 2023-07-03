package ObjectClasses;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class userEnquiry {
    WebDriver driver;

    public userEnquiry(WebDriver driver)
    {
        this.driver=driver;
    }

    public int enquirybuttoncount()
    {
        WebElement navbarDropdown = driver.findElement(By.id("navbarDropdown1"));
        click(navbarDropdown);
        List<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/div/a"));
        int cardscount=0;
        for (WebElement element : options) {
            String optionsLink = element.getAttribute("href");

            ((JavascriptExecutor) driver).executeScript("window.open();");
            driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
            driver.get(optionsLink);

            List<WebElement> cards = driver.findElements(By.className("product-toys-info"));
            for (WebElement card : cards) {
                cardscount++;
            }

            driver.close();
            driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        }
        return cardscount;
    }

    public int enquirybutton()
    {
        WebElement navbarDropdown = driver.findElement(By.id("navbarDropdown1"));
        click(navbarDropdown);        
        
        List<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/div/a"));
        int actualenquirybuttoncount = 0;
        for (WebElement element : options) {
            String optionsLink = element.getAttribute("href");
            String nameArtype = element.getAttribute("textContent");

            ((JavascriptExecutor) driver).executeScript("window.open();");
            driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
            driver.get(optionsLink);

            List<WebElement> cards = driver.findElements(By.className("product-toys-info"));
            if (driver.getPageSource().contains("Enquiry")) {
                for (WebElement card : cards) {
                    String productName = card.findElement(By.tagName("h4")).getText();

                    String enquirybutton = card.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/div/h4/button/a")).getAttribute("href");

                    ((JavascriptExecutor) driver).executeScript("window.open();");
                    driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
                    driver.get(enquirybutton);

                    String enquiryheadlline = driver.getTitle();
                    System.out.println("Art Type with product availaible "+nameArtype+ ":- ");

                    System.out.println(enquiryheadlline + " button clicked for "+productName);

                    driver.close();
                    driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

                    actualenquirybuttoncount++;
                }
            }

            if(driver.getPageSource().contains("No Record Found"))
                {
                    System.out.println("Art Type with no product records: "+nameArtype);
                    String displayedmessage = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/h3")).getText();
                    // System.out.println(displayedmessage);
                }

            driver.close();

            driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        }
        return actualenquirybuttoncount;
    }

    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

}
