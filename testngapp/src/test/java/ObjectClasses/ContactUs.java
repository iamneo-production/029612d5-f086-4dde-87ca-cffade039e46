package ObjectClasses;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs {
    WebDriver driver;

    public ContactUs(WebDriver driver)
    {
        this.driver=driver;
    }

    public void scrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void navigateToPages() {
        WebElement pages = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/a"));
        click(pages);
    }
    
    public void submenuElements() {
        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/ul"));
        WebElement element = menu.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[8]/ul/li[2]/a"));

        System.out.println(element.getText());
    }

    public void pageSubmenu() {
        navigateToPages();
        submenuElements();
    }
    
    public void navigateToContactUsPage() {
        WebElement contactus = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[8]/ul/li[2]/a"));
        click(contactus);
    }
    
    public void fillPagedetails(String title, String email, String phonenumber, String timings) {
        
        driver.findElement(By.name("pagetitle")).clear();
        driver.findElement(By.name("pagetitle")).sendKeys(title);
        System.out.println("Updated title for contact us: "+title);
        
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        System.out.println("Updated email for contact us: "+email);
        
        driver.findElement(By.name("phonenum")).clear();
        driver.findElement(By.name("phonenum")).sendKeys(phonenumber);
        System.out.println("Updated phone number for contact us: "+phonenumber);
        
        driver.findElement(By.name("timing")).clear();
        driver.findElement(By.name("timing")).sendKeys(timings);
        System.out.println("Updated timings for contact us: "+timings);
    }

    public void fillPageDescription(String description) {
        System.out.println("in description");
        scrollBy();
        WebElement elm = driver.findElement(By.xpath("/html/body/section/section/section/div[3]/div/section/div/div/form/div[5]/div/div[2]/div"));
        elm.clear();
        elm.sendKeys(description);
        System.out.println("Updated description for contact us: "+description);
    }
    
    public void clickUpdateButton() {
        driver.findElement(By.name("submit")).isEnabled();
        WebElement update = driver.findElement(By.name("submit"));
        click(update);
    }

    public void checkContactUs(String usertitle, String useremail, String userphonenumber, String usertimings , String userdescription){

        System.out.println("Checking information at user side...");

        ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("http://artgallery.neohire.io/");

            WebElement navContactus=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a"));
            click(navContactus);

            String usercontactuspagetitle = driver.findElement(By.xpath("/html/body/section/div/div/div/h4")).getText();
            System.out.println("User side Title: " + usercontactuspagetitle);
            
            String usercontactuspageemail = driver.findElement(By.xpath("/html/body/section/div/div/div/div[3]/p")).getText();
            System.out.println("User side Email: " + usercontactuspageemail);
            
            String userPhoneandTimings = driver.findElement(By.xpath("/html/body/section/div/div/div/div[2]/p")).getText();
            System.out.println("User side Phone number  and Timings: " + userPhoneandTimings);

            String usercontactuspagedesciption = driver.findElement(By.xpath("/html/body/section/div/div/div/div[1]/p[1]")).getText();
            System.out.println("User side Description: " + usercontactuspagedesciption);

            boolean booleanTitle= usercontactuspagetitle.equals(usertitle);
            boolean booleanEmail= usercontactuspageemail.equals(usertitle);

            boolean booleanDescription = usercontactuspagedesciption.equals(userdescription);

            boolean verified = booleanTitle && booleanEmail && booleanDescription;

            if(verified){
                System.out.println("Verified: User side updated properly for Contact us.");
            }else{
                System.out.println("Incorrect information for Contact Us.");
            }

            driver.close();
            driver.switchTo().window(tabs.get(0));
    }


    public void updateContactUsPage(String title,String email, String phonenumber, String timings, String description) {
        navigateToPages();
        navigateToContactUsPage();
        fillPagedetails(title, email, phonenumber, timings);
        fillPageDescription(description);
        clickUpdateButton();
    }

    public void userSideCheckContactus(String usertitle, String useremail, String userphonenumber, String usertimings, String userdescription){        
        checkContactUs(usertitle , useremail , userphonenumber , usertimings , userdescription);
    }

    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

}
