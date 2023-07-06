package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userLinks;

public class userLinksTest extends SetupDriver{

    @BeforeClass
    public void artType() {
        System.out.println("\n\n|| USER LINKS ||");
    }


    @Test(priority = 0)
    public void linkcheck()
    {
        userLinks uLinks = new userLinks(driver);

        String artgallerytitle = uLinks.linkArtgallery();
        assertEquals("Art Gallery Management System | Home Page",artgallerytitle);        
        uLinks.homepage();

        String readmoretitle = uLinks.linkreadmore();
        assertEquals("Art Gallery Management System | About Us Page",readmoretitle);
        uLinks.homepage();

        String arrowtitle = uLinks.linkarrow();
        assertEquals("Art Gallery Management System | Home Page",arrowtitle);
        uLinks.homepage();
    }
}
