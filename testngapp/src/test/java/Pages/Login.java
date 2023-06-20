package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {
    WebDriver driver;
    String username = "admin";
    String password = "Test@123";

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToAdminLoginPage() {
        WebElement navAdmin = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[5]/a"));
        navAdmin.click();
    }
    

    public void sendUsernameKey(String username) {
        WebElement usernameInput = driver.findElement(By.xpath("/html/body/div/form/div/div[1]/input"));
        usernameInput.sendKeys(username);
    }

    public void sendPasswordKey(String password) {
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/input"));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/form/div/lable/button"));
        loginButton.click();
    }

    public void delay() throws InterruptedException  {
        Thread.sleep(10000);
    }

    public void adminLogin() {
        navigateToAdminLoginPage();
        sendUsernameKey(username);
        sendPasswordKey(password);
        clickLoginButton();
    }

    public void adminLogin(String username, String password) {
        System.out.println("Up");
        navigateToAdminLoginPage();
        System.out.println("Down");
        sendUsernameKey(username);
        sendPasswordKey(password);
        clickLoginButton();
    }
    public void navigateToAdminLogoutPage() {
        // Error in xpath 
        WebElement navAdmin = driver.findElement(By.xpath("//*[@id='container']/header/div[2]/ul/li[2]/a"));
        navAdmin.click();
        WebElement logoutTag = driver.findElement(By.xpath("//*[@id='container']/header/div[2]/ul/li[2]/ul/li[3]/a"));
        logoutTag.click();

    }
    public void backToHomepage(){
        WebElement backToHomepage = driver.findElement(By.xpath("/html/body/div[1]/form/div/lable/p/a"));
        backToHomepage.click();
    }

    public void logout(){
        navigateToAdminLogoutPage();
        backToHomepage();
    }
}