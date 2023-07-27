package TestCaseClasses;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.ArtType;
import ObjectClasses.SetupDriver;

public class ArtTypeTest extends SetupDriver{

    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| ARTTYPE ||");
    }
    
    @Test(priority = 9, groups = {"admin", "arttype"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void addArtTypeTest() {
        test.assignCategory("Art");

        ArtType artType = new ArtType(driver);
        //Adding Art type as pottery  
        artType.addArtType("pottery");
        
        //Switching to the alert box and retriveing the text message
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept(); 
        
        //Checking whether Art type is added successfully or not 
        Assert.assertEquals("Artist type has been added.", alertMsg); 
        System.out.println("\nArtType Added SuccessFully!");

        //Displaying all the available art type
        artType.printTable();
    }
    
    @Test(priority = 10, groups = {"admin", "arttype"}, dependsOnMethods = "addArtTypeTest")
    public void updateArtTypeTest() {
        test.assignCategory("Art");
        ArtType artType = new ArtType(driver);
        //updating Art type pottery as Sculpture 
        artType.updateArtType("Sculpture");


         //Switching to the alert box and retriveing the text message
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    

        //Checking whether Art type is updated successfully or not
        Assert.assertEquals("Art type has been updated.", alertMsg); 
        System.out.println("\nArtType Updated Successfully!");
        artType.navigateToManagetoArtTypePage();

        //Displaying all the available art type
        artType.printTable();
    }
    
    @Test(priority = 11, groups = {"admin", "arttype"}, dependsOnMethods = "addArtTypeTest")
    public void deleteArtTypeTest() {
        test.assignCategory("Art");
        ArtType artType = new ArtType(driver);
        //Deleting the Art type Sclpture
        artType.deleteArtType();

         //Switching to the alert box and retriveing the text message
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    

        //Checking whether Art type is deleted successfully or not
        Assert.assertEquals("Data deleted", alertMsg); 
        System.out.println("\nArtType Deleted Successfully!");
        
        //Displaying all the available art type 
        artType.printTable();
    }
}