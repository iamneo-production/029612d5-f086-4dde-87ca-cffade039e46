package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enquiry {
    WebDriver driver;

    public Enquiry(WebDriver driver){
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


    //To get the Table data
    public List<List<WebElement>> getTableData() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody"));

        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<List<WebElement>> data = new ArrayList<>();

        if(rows.size() > 0){
            for(WebElement row:rows){
                List<WebElement> cols = row.findElements(By.tagName("td"));
                List<WebElement> rowData = new ArrayList<>();
        
                for (WebElement col : cols) {
                    rowData.add(col);
                }
    
                data.add(rowData);
            }
        }

        return data;
    }
    //To print the Table data

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
        int numCols = table.get(1).size();
        
        // Calculate the maximum width of each column
        int[] colWidths = new int[numCols];
        for (List<String> row : table) {
            if(row.size()>0){
                for (int i = 0; i < numCols; i++) {
                    int width = row.get(i).length();
                    if (width > colWidths[i]) {
                        colWidths[i] = width;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < colWidths.length; i++) {
            sum += colWidths[i];
        }
        

        // Print the table
        for (int i=1;i<table.size();i++) {
            for (int j = 0; j < numCols; j++) {
                String cell = table.get(i).get(j);
                int padding = colWidths[j] - cell.length();
                System.out.print(cell + " ".repeat(padding + 2));
            }
            if(i==1){
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



    // Dashboard Details
    public void navigateToAnsweredEnquiryDetails() {
        WebElement details=driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[3]/div/div[2]/a"));
        click(details);
    }

    public List<List<WebElement>> AnsweredEnquiryDetails() {
        navigateToAnsweredEnquiryDetails();
        return getTableData();
    }
    //Navigate to unanswered enquiry details
    public void navigateToUnansweredEnquiryDetails() {
        WebElement navigateUnanswered=driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[2]/div/div[2]/a"));
        click(navigateUnanswered);
    }

    public List<List<WebElement>> UnansweredEnquiryDetails() {
        navigateToUnansweredEnquiryDetails();
        return getTableData();
    }

    //To open new tab
    public void openNewTab() {
		((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }
    //To close new tab
    public void closeNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    

    //Navigate to Enquiry page in user
    public void navigateToEnquiryPageinUser() {
        driver.get("https://artgallery.neohire.io/");
        WebElement navbar=driver.findElement(By.xpath("//*[@id='navbarDropdown1']"));
        click(navbar);
        //WebDriverWait wait = new WebDriverWait(driver,  10);
		WebElement nav = driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[3]/div/a[4]"));
        click(nav);
        
        WebElement enquiryBtn = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/div/h4/button/a"));
        scrollToWebElement(enquiryBtn);    
        click(enquiryBtn);

    }
    
    public void fillName(String name) {
        driver.findElement(By.name("fullname")).isDisplayed();
        driver.findElement(By.name("fullname")).sendKeys(name);
    }

    public void fillEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void fillNumber(String number) {
        driver.findElement(By.name("mobnum")).sendKeys(number);
    }

    public void fillMessage(String msg) {
        driver.findElement(By.name("message")).sendKeys(msg);
    }
    
    public void clickSend() {
        WebElement send = driver.findElement(By.name("send"));
        click(send);
    }

    public void addEnquiry(String name, String email, String number, String msg) {
        navigateToEnquiryPageinUser();
        scrollBy();
        fillName(name);
        fillEmail(email);
        fillNumber(number);
        fillMessage(msg);
        clickSend();
    }

    public WebElement getRowElement(String value) {
        WebElement elm = driver.findElement(By.xpath("//tr[td[contains(text(),'" + value + "')]]"));
        return elm;
    }




    public void navigateToManageUnansweredEnquiryPage() {
        WebElement manage=driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/a"));
        click(manage);
        WebElement manageUnanswered=driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/ul/li[1]/a"));
        click(manageUnanswered);
    }
    // To view details of data
    public void clickViewDetailsButton(String enquiryNumber) {
        WebElement row = getRowElement(enquiryNumber);
        scrollToWebElement(row);
        WebElement elm = row.findElement(By.tagName("a"));
        driver.get(elm.getAttribute("href"));

        // scrollBy();
        // int dataSize = getTableData().size();
        // String path = "//*[@id=\"main-content\"]/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[6]/a";
        // WebElement viewDetails=driver.findElement(By.xpath(path));
        // click(viewDetails);
    }

    public void fillRemarks(String remark) {
        driver.findElement(By.name("remark")).sendKeys(remark);
    }

    public void clickUpdateButton() {
        WebElement update=driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div/section/table/tbody/tr[7]/td/button"));
        click(update);
    } 
    
    public String getRemarkDate() {
        return driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[7]/td")).getText();
    }
    // To print Enquiry details
    public void printEnquiryDetails() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody"));

        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        for(WebElement row:rows){
            List<WebElement> th = row.findElements(By.tagName("th"));
            List<WebElement> td = row.findElements(By.tagName("td"));

            for(int i=0;i<th.size();i++){
                System.out.println(th.get(i).getText() + " : " + td.get(i).getText());
            }
        }
    }
    // to execute unansweredenquiry
    public void unansweredEnquiry(String enquiryNumber) {
        navigateToManageUnansweredEnquiryPage();
        clickViewDetailsButton(enquiryNumber);
        System.out.println("\nUnanswered Enquiry Details \n");
        printEnquiryDetails();
        fillRemarks("Successfully Answered!");
        clickUpdateButton();
    }

    // To get Enquiry number
    public String getEnquiryNumber() {
        return driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[1]/td")).getText();
    }

    //Navigate to AnsweredEnquiry page
    public void navigateToManageAnsweredEnquiryPage() {
        WebElement enquirypages=driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/a"));
        click(enquirypages);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        WebElement answeredEnquiry=driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/ul/li[2]/a"));
        click(answeredEnquiry);
        
    }

    //To execute answeredEnquiry
    public void answeredEnquiry(String enquiryNumber) {
        navigateToManageAnsweredEnquiryPage();
        clickViewDetailsButton(enquiryNumber);
    }

    public void sendkeys(WebElement element, String value){
        JavascriptExecutor jse = ((JavascriptExecutor)driver);        	
        jse.executeScript("arguments[0].value="+value+";", element);
    }

    // Search Enquiry
    public String fetchSearchData(String enquiryNumber) {
        navigateToManageAnsweredEnquiryPage();
        if(enquiryNumber.length()>0){
            WebElement row = getRowElement(enquiryNumber);
            scrollToWebElement(row);
            return row.getText();
        }
        else{
            int dataSize = getTableData().size();
            scrollBy();
            return driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + " ]")).getText();
        }
    }

    public void navigateEnquirySearchPage() {
        WebElement navSearch=driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[7]/a"));
        click(navSearch);
    }
    
    public void fillSearchQuery(String search) {
        WebElement fillsearch =  driver.findElement(By.xpath("//*[@id='searchdata']"));
        fillsearch.sendKeys(search);
        // sendkeys(fillsearch, search);
    }

    public void clickSubmitButton() {
        WebElement clickSubmit=driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > header > form > p > button"));
        click(clickSubmit);
    }

    public List<List<WebElement>> enquirySearch(String search) {
        navigateEnquirySearchPage();
        fillSearchQuery(search);
        clickSubmitButton();
        return getTableData();
    }
}
