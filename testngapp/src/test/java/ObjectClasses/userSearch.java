package ObjectClasses;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class userSearch {
    WebDriver driver;

    public userSearch(WebDriver driver)
    {
        this.driver=driver;
    }

    public void navigatetoSearchPage(){
        driver.navigate().to("https://artgallery.neohire.io/product.php");
    }


    public void searchimplementation(String searchName){

    driver.findElement(By.name("search")).sendKeys(searchName);      
    WebElement submit = driver.findElement(By.name("submit"));
    click(submit);

    String searchmessage = driver.findElement(By.xpath("/html/body/section/div/h2")).getText();
    System.out.println(searchmessage);

    List<WebElement> cards = driver.findElements(By.className("product-toys-info"));
        if (driver.getPageSource().contains("Enquiry")) {
            for (WebElement card : cards) {
                String productName = card.findElement(By.tagName("h4")).getText();

                System.out.println("Search for "+searchName +" is "+productName+".");
            }
        }

        if(driver.getPageSource().contains("No Record Found"))
        {
            System.out.println("No Products availaible for "+searchName+" search.");
        }

    }

    public void search(String searchproductname){
        navigatetoSearchPage();
        searchimplementation(searchproductname);
    }

    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

}
