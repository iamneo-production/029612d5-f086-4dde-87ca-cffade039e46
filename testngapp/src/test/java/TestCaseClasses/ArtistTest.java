package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.Artist;
import ObjectClasses.SetupDriver;

public class ArtistTest extends SetupDriver{

    String imgpath = "/home/seluser/sample2.jpeg";
    
    @BeforeClass(alwaysRun=true)
    public void artType() {
        System.out.println("\n\n|| ARTIST ||");
    }
    
    @Test(priority = 6, groups = {"admin", "artist", "smoketest"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void addArtistTest() {
        // login.adminLogin();
        Artist artist = new Artist(driver);

        artist.addArtist("Rock", "1234567890", "rock@gmail.com", "exampleEducation", "exampleEducation", imgpath);

    
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Artist details has been added.", alertMsg); 
        System.out.println("\nArtist Added SuccessFully!");
        artist.printTable();
    }

    @Test(priority = 7, groups = {"admin", "artist"}, dependsOnMethods = "addArtistTest")
    public void updateArtistTest() {
        // login.adminLogin();
        Artist artist = new Artist(driver);
        artist.updateArtist("john", "1234567890", "john@gmail.com", "exampleEducation", "exampleEducation", imgpath);

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Artist details has been updated.", alertMsg); 
        System.out.println("\nArtist Updated SuccessFully!");
        artist.navigateToManagetoArtistPage();
        artist.printTable();
    }

    @Test(priority = 8, groups = {"admin", "artist", "smoketest"}, dependsOnMethods = "addArtistTest")
    public void deleteArtistTest() {
        // login.adminLogin();
        Artist artist = new Artist(driver);
        artist.deleteArtist();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Data deleted", alertMsg); 
        System.out.println("\nArtist Deleted SuccessFully!");
        artist.printTable();
    }
}
