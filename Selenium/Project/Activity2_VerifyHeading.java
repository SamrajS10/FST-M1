package Activity2_VerifyHeading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2_VerifyHeading 
{
    @Test
    public void verifyWebsiteHeading() 
    {
    	WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String actualHeading = driver.findElement(
                By.xpath("//h1")
        ).getText();
        System.out.println("Website heading is: " + actualHeading);
        String expectedHeading = "Learn from Industry Experts";
        Assert.assertEquals(actualHeading, expectedHeading,
                "Website heading does not match!");
        driver.quit();
    }
}

