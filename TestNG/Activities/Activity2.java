package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 
{

    WebDriver driver;

    @BeforeClass
    public void setUp() 
    {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice/");
    }

    @Test
    public void testPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testBlackButtonIncorrectAssertion() 
    {
        String buttonText = driver.findElement(By.className("black")).getText();
        System.out.println("Black Button Text: " + buttonText);

        // Incorrect assertion on purpose
        Assert.assertEquals(buttonText, "White Button");
    }
    @Test(enabled = false)
    public void testDisabledMethod() 
    {
        System.out.println("This test is disabled");
    }

    @Test
    public void testSkippedWithException() {
        throw new SkipException("Skipping this test using SkipException");
    }

    @AfterClass
    public void tearDown() 
    {
        driver.close();
    }
}

