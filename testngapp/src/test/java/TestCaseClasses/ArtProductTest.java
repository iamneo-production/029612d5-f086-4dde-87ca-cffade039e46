package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.ArtProduct;
import ObjectClasses.SetupDriver;

public class ArtProductTest extends SetupDriver{
    
    // String imgpath = System.getProperty("user.dir") + "/resources/illustration4.jpg";
    String imgpath = "/home/seluser/sample2.jpeg";

    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| ART PRODUCT ||");
    }

    @Test(priority = 0)
    public void addArtProductTest() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        artProduct.addArtProduct("Marvel", imgpath, "1000", "Potrait", "Medium", "Maddy", "Painting", "Oil on Canvas", "7000", "ARTISTIC PAINTINGS... ");
 
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();     
        
        assertEquals("Art product details has been submitted.", alertMsg); 
        System.out.println("\nArt Product Added SuccessFully!");
        artProduct.navigateToManagetoArtProductPage();
        artProduct.printTable();
    }

    @Test(priority = 1)
    public void updateArtProductTest() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        artProduct.updateArtProduct("Illustration", imgpath, "1000", "Landscape", "Small", "Abir Rajwansh", "Prints", "Acrylics on paper", "5000", "Cool Illustration... ");

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();     
        
        assertEquals("Art product has been updated.", alertMsg); 
        System.out.println("\nArt Product Updated SuccessFully!");
        artProduct.navigateToManagetoArtProductPage();
        artProduct.printTable();
    }

    @Test(priority = 2)
    public void deleteArtProductTest() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        artProduct.deleteArtProduct();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();     
        
        assertEquals("Data deleted", alertMsg); 
        System.out.println("\nArt Product Deleted SuccessFully!");
        artProduct.printTable();
    }

}
