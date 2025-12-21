package Activity6_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6_Login 
{

    @Test
    public void loginToLMS() throws InterruptedException 
    {
        WebDriver driver = new FirefoxDriver();

        try 
        {
            driver.get("https://alchemy.hguy.co/lms");
            WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
            myAccountLink.click();
            Thread.sleep(2000);
            String pageTitle = driver.getTitle();
            System.out.println("Page title is: " + pageTitle);
            Assert.assertEquals(pageTitle, "My Account – Alchemy LMS", "Not on My Account page");
            WebElement loginButtonHeader = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
            loginButtonHeader.click();
            Thread.sleep(2000);
            
            WebElement usernameField = driver.findElement(By.id("user_login"));
            usernameField.sendKeys("root");
            
            WebElement passwordField = driver.findElement(By.id("user_pass"));
            passwordField.sendKeys("pa$$w0rd");

            WebElement loginButton = driver.findElement(By.id("wp-submit"));
            loginButton.click();

            Thread.sleep(3000);

            WebElement logoutLink = driver.findElement(By.linkText("Logout"));
            Assert.assertTrue(logoutLink.isDisplayed(), "Login failed!");

            System.out.println("Login successful.");

        } 
        finally 
        {

            driver.quit();
        }
    }
}
