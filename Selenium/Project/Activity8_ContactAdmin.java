package Activity8_ContactAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity8_ContactAdmin 
{
    @Test
    public void contactAdmin() throws InterruptedException 
    {
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://alchemy.hguy.co/lms");
            WebElement contactLink = driver.findElement(By.linkText("Contact"));
            contactLink.click();
            Thread.sleep(2000);
            WebElement fullNameField = driver.findElement(By.id("wpforms-8-field_0"));
            fullNameField.sendKeys("John Cena");

            WebElement emailField = driver.findElement(By.id("wpforms-8-field_1"));
            emailField.sendKeys("johncena@example.com");

            WebElement subjectField = driver.findElement(By.id("wpforms-8-field_3"));
            subjectField.sendKeys("Test Inquiry");

            WebElement messageField = driver.findElement(By.id("wpforms-8-field_2"));
            messageField.sendKeys("This is a test message from Selenium automation.");
           
            WebElement submitButton = driver.findElement(By.id("wpforms-submit-8"));
            submitButton.click();

            Thread.sleep(2000);
            
            WebElement successMessage = driver.findElement(By.cssSelector(".wpforms-confirmation-container"));
            System.out.println("Form submission message: " + successMessage.getText());
        } finally 
        {
            driver.quit();
        }
    }
}
