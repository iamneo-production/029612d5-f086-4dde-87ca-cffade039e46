package ObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userViewDetails extends userEnquiry{
    WebDriver driver;

    public userViewDetails(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }

    public void viewDetails(){
        userEnquiry uenquiry = new userEnquiry(driver);

        int productcount = uenquiry.enquirybuttoncount();
        if(productcount > 0)
        {
            homepage();
            viewDetailsimplementation();
            
        }else{
            System.out.println("No Product available for detailing.");
        }
    }

    public void viewDetailsimplementation()
    {
        WebElement navbarDropdown = driver.findElement(By.id("navbarDropdown1"));
        click(navbarDropdown);
        List<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/div/a"));
        
        for (WebElement element : options) {

            String optionsLink = element.getAttribute("href");
            String nameArtype = element.getAttribute("textContent");

            ((JavascriptExecutor) driver).executeScript("window.open();");
            driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
            driver.get(optionsLink);

            List<WebElement> cards = driver.findElements(By.className("product-toys-info"));

            System.out.println("Option Name: "+nameArtype);
            System.out.println(nameArtype+ ": Product Page");
            if (driver.getPageSource().contains("Enquiry")) {
                System.out.println("Availaible Products- ");

                for (WebElement card : cards) {

                    String productName = card.findElement(By.tagName("h4")).getText();
                    System.out.println("\n");

                    System.out.println(productName);
                    String viewdetailsbutton = card.findElement(By.className("link-product-add-cart")).getAttribute("href");

                    ((JavascriptExecutor) driver).executeScript("window.open();");
                    driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
                    driver.get(viewdetailsbutton);
                    
                    List<WebElement> details = driver.findElements(By.className("inner-sec-shop"));
                    
                    for(WebElement detail : details){

                        String productheading = detail.findElement(By.tagName("h3")).getText();
                        List<WebElement> physicaldetails = driver.findElements(By.className("color-quality"));

                        for(WebElement product : physicaldetails){
                            System.out.println(product.getText());
                        }

                        List<WebElement> artdetails= driver.findElements(By.className("occasional"));
                        for(WebElement product : artdetails){
                            System.out.println(product.getText());
                        }
                    }
                    driver.close();
                    driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
                    System.out.println();
                }
            }else{
                System.out.println("\tNo Product Available");
            }
            driver.close();
            driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
            System.out.println("\n");

        }
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
