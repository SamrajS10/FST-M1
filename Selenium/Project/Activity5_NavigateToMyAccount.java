package Activity5_NavigateToMyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity5_NavigateToMyAccount 
{

    @Test
    public void navigateToMyAccountPage() 
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.linkText("My Account")).click();
        String actualTitle = driver.getTitle();
        System.out.println("The page title is: " + actualTitle);
        String expectedTitle = "My Account – Alchemy LMS";
        Assert.assertEquals(actualTitle, expectedTitle,
                "User is not on My Account page!");
        driver.quit();
    }
}

