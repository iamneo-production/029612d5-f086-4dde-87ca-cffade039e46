package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Artist {
    WebDriver driver;

    public Artist(WebDriver driver){
        this.driver = driver;
    }

    public void scrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollToWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }




    public void navigateToArtistDetails() {
        WebElement elm = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/div[2]/a"));
        click(elm);
    }

    public List<List<WebElement>> getTableData() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody"));

        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<List<WebElement>> data = new ArrayList<>();

        for(WebElement row:rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));
            List<WebElement> rowData = new ArrayList<>();
    
            for (WebElement col : cols) {
                rowData.add(col);
            }

            data.add(rowData);
        }

        
        return data;
    }

    public void printTable() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody"));
        
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        for(WebElement row:rows){
            scrollToWebElement(row);
            System.out.println(row.getText().split("Edit")[0]);
        }
    }
    
    public List<List<WebElement>> dashboardDetails() {
        navigateToArtistDetails();
        return getTableData();
    }
    





    // Adding Artist
    public void navigateToAddtoArtistPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[2]/ul/li[1]/a")).click();
    }

    public void fillName(String name) {
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys(name);
    }

    public void fillNumber(String number) {
        driver.findElement(By.xpath("//*[@id='mobnum']")).sendKeys(number);
    }

    public void fillEmail(String email) {
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
    }

    public void fillEducation(String education) {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/div[4]/div/textarea")).sendKeys(education);
    }

    public void fillAward(String award) {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/div[5]/div/textarea")).sendKeys(award);
    }

    public void fillImage(String imagePath) {
        driver.findElement(By.xpath("//*[@id='images']")).sendKeys(imagePath);
    }

    public void clickSubmitButton() {
        driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > div > form > p > button")).click();
    }

    public void addArtist(String name, String number, String email, String education, String award, String imagePath) {
        navigateToAddtoArtistPage();
        fillName(name);
        fillNumber(number);
        fillEmail(email);
        fillEducation(education);
        fillAward(award);
        scrollBy();
        fillImage(imagePath);
        clickSubmitButton();
    }






    // Manage Artist 
    public void navigateToManagetoArtistPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[2]/a")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[2]/ul/li[2]/a")).click();
    }






    // Update Artist
    public void clickEditButton() {
        int dataSize = getTableData().size();
        scrollBy();
        String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[6]/a[1]";
        driver.findElement(By.xpath(path)).click();
    }

    public void editName(String name) {
        driver.findElement(By.xpath("//*[@id='name']")).clear();
        fillName(name);
    }
    
    public void editEmail(String email) {
        driver.findElement(By.xpath("//*[@id='email']")).clear();
        fillEmail(email);
    }
    
    public void editNumber(String number) {
        driver.findElement(By.xpath("//*[@id='mobnum']")).clear();
        fillNumber(number);
    }
    
    public void editEducation(String education) {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/div[4]/div/textarea")).clear();
        fillEducation(education);
    }
    
    public void editAward(String award) {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/div[5]/div/textarea")).clear();
        fillAward(award);
    }
    
    public void navigateToEditImage() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/div[6]/div/a")).click();
    }

    public void editImage(String image) {
        driver.findElement(By.xpath("//*[@id='images']")).sendKeys(image);
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button")).click();
        
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.navigate().back();
        driver.navigate().back();
    }

    public void clickUpdateButton() {
        driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > div > form > p:nth-child(8) > button")).click();
    }
    
    public void updateArtist(String name, String number, String email, String education, String award, String imagePath) {
        // navigateToManagetoArtistPage();
        List<List<WebElement>> data = getTableData();
        
        if(data.size() > 0){
            clickEditButton();
            editName(name);
            editNumber(number);
            editEmail(email);
            editEducation(education);
            editAward(award);
            scrollBy();
            navigateToEditImage();
            editImage(imagePath);
            clickUpdateButton();
        }
    }





    
    // Delete Artist
    public void clickDeleteButton() {
        int dataSize = getTableData().size();
        scrollBy();
        if(dataSize > 0){
            String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[6]/a[2]";
            driver.findElement(By.xpath(path)).click();
        }
    }

    public void deleteArtist() {
        clickDeleteButton();
    }

}
