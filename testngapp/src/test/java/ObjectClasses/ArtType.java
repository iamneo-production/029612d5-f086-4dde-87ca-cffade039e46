package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArtType {
    WebDriver driver;

    public ArtType(WebDriver driver){
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

    public void navigateToArtTypeDetails() {
       WebElement arttype= driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div[1]/div/div[2]/a"));
       click(arttype);
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
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table"));
        
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<List<String>> table = new ArrayList<>();
        
        for(WebElement row:rows){
            scrollToWebElement(row);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if(cols.size()<1){
                cols = row.findElements(By.tagName("th"));
            }
            
            List<String> data = new ArrayList<>();
            for(int col=0;col<cols.size()-1;col++){
                data.add(cols.get(col).getText());
            }

            table.add(data);
        }
        
        int numCols = table.get(0).size();
        
        // Calculate the maximum width of each column
        int[] colWidths = new int[numCols];
        for (List<String> row : table) {
            for (int i = 0; i < numCols; i++) {
                int width = row.get(i).length();
                if (width > colWidths[i]) {
                    colWidths[i] = width;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < colWidths.length; i++) {
            sum += colWidths[i];
        }
        

        // Print the table
        for (int i=0;i<table.size();i++) {
            for (int j = 0; j < numCols; j++) {
                String cell = table.get(i).get(j);
                int padding = colWidths[j] - cell.length();
                System.out.print(cell + " ".repeat(padding + 2));
            }
            if(i==0){
                System.out.println();
                for(int k=0;k<sum;k++){
                    System.out.print("-");;
                }
                System.out.println();
            }
            else{
                System.out.println();
            }
        }
    }

    public List<List<WebElement>> dashboardDetails() {
        navigateToArtTypeDetails();
        return getTableData();
    }







    // Add Arttype
    public void navigateToAddtoArtTypePage() {
        //navigating  to Art type page
       WebElement nav= driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a"));
       click(nav);
       //navigating to Add Type page
        WebElement nav2= driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/ul/li[1]/a"));
        click(nav2);
    }

    public void fillArtType(String artType) {
        //Passing the Art type to be added
        driver.findElement(By.xpath("//*[@id='arttype']")).sendKeys(artType);
    }

    public void clickSubmitButton() {
       //click on submit button
       WebElement sub= driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > div > form > div:nth-child(2) > p > button"));
       click(sub);
    }

    public void addArtType(String artType) {
        //Performing the Add Art type operation
        navigateToAddtoArtTypePage();
        fillArtType(artType);
        clickSubmitButton();
    }







    // Manage arttype
    public void navigateToManagetoArtTypePage() {
       WebElement ele1= driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a"));
       click(ele1);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
       WebElement ele2= driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/ul/li[2]/a"));
       click(ele2);
    }




    // Update ArtType
    public void clickEditButton() {
        int dataSize = getTableData().size();
        scrollBy();
        String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[4]/a[1]";
       WebElement ele= driver.findElement(By.xpath(path));
       click(ele);
    }

    public void editArtType(String artType) {
        //Passing the updated Art type 
        driver.findElement(By.xpath("//*[@id='arttype']")).clear();
        fillArtType(artType);
    }

    public void clickUpdateButton() {
        //clicking on the update button 
       WebElement ele= driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button"));
       click(ele);
    }

    public void updateArtType(String artType) {
        navigateToManagetoArtTypePage();
        List<List<WebElement>> data = getTableData();
        //checking whether  art type is not empty to perform updation
        if(data.size() > 0){
            //click on the Edit button 
            clickEditButton();
            editArtType(artType);
            clickUpdateButton();
        }
    }




    // Delete ArtType
    public void clickDeleteButton() {
        int dataSize = getTableData().size();
        scrollBy();
        //checking whether Art type not empty to perform deletion 
        if(dataSize > 0){
            String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[4]/a[2]";
            //click on the delete button
           WebElement ele= driver.findElement(By.xpath(path));
           click(ele);
        }
    }

    public void click(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    public void deleteArtType() {
        navigateToManagetoArtTypePage();
        clickDeleteButton();
    }
}