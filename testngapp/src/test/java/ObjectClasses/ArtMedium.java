package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArtMedium {
    WebDriver driver;

    public ArtMedium(WebDriver driver){
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


    public void navigateToArtMediumDetails() {
        WebElement elm = driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div[2]/div/div[2]/a"));
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
        navigateToArtMediumDetails();
        return getTableData();
    }





    
    // Adding ArtMedium
    public void navigateToAddtoArtMediumPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/ul/li[1]/a")).click();
    }

    public void fillArtMedium(String artMedium) {
        driver.findElement(By.xpath("//*[@id='artmed']")).sendKeys(artMedium);
    }

    public void clickSubmitButton() {
        driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > div > form > div:nth-child(2) > p > button")).click();
    }

    public void addArtMedium(String artMedium) {
        navigateToAddtoArtMediumPage();
        fillArtMedium(artMedium);
        clickSubmitButton();
    }





    
    // Manage artMedium
    public void navigateToManagetoArtMediumPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/a")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/ul/li[2]/a")).click();
    }




    // Update ArtMedium
    public void clickEditButton() {
        int dataSize = getTableData().size();
        scrollBy();
        String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[4]/a[1]";
        driver.findElement(By.xpath(path)).click();
    }

    public void editArtMedium(String artMedium) {
        driver.findElement(By.xpath("//*[@id='artmed']")).clear();
        fillArtMedium(artMedium);
    }

    public void clickUpdateButton() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button")).click();
    }

    public void updateArtMedium(String artMedium) {
        navigateToManagetoArtMediumPage();
        List<List<WebElement>> data = getTableData();
        
        if(data.size() > 0){
            clickEditButton();
            editArtMedium(artMedium);
            clickUpdateButton();
        }
    }





    
    // Delete ArtMedium
    public void clickDeleteButton() {
        int dataSize = getTableData().size();
        scrollBy();
        if(dataSize > 0){
            String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[4]/a[2]";
            driver.findElement(By.xpath(path)).click();
        }
    }

    public void deleteArtMedium() {
        navigateToManagetoArtMediumPage();
        clickDeleteButton();
    }
}
