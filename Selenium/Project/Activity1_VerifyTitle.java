package Activity1_VerifyTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1_VerifyTitle 
{

    @Test
    public void verifyWebsiteTitle() 
    {
    	WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String actualTitle = driver.getTitle();
        System.out.println("The title is: " + actualTitle);
        String expectedTitle = "Alchemy LMS – An LMS Application";
        Assert.assertEquals(actualTitle, expectedTitle,
                "Website title does not match!");
        driver.quit();
    }
}
