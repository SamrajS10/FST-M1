package Activity3_VerifyFirstInfoBoxTitle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3_VerifyFirstInfoBoxTitle 
{

    @Test
    public void verifyFirstInfoBoxTitle() 
    {
    	WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String actualTitle = driver.findElement(
                By.xpath("(//h3)[1]")
        ).getText();
        System.out.println("The InfoBox title is: " + actualTitle);
        String expectedTitle = "Actionable Training";
        Assert.assertEquals(actualTitle, expectedTitle,
                "First info box title does not match!");
        driver.quit();
    }
}

