package Activity4_VerifySecondPopularCourse;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4_VerifySecondPopularCourse 
{

    @Test
    public void verifySecondMostPopularCourseTitle() 
    {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String actualCourseTitle = driver.findElement(
                By.xpath("(//h3[@class='entry-title'])[2]")
        ).getText();
        System.out.println("The Course title is: " + actualCourseTitle);
        String expectedCourseTitle = "Email Marketing Strategies";

        Assert.assertEquals(actualCourseTitle, expectedCourseTitle,
                "Second most popular course title does not match!");
        driver.quit();
    }
}
