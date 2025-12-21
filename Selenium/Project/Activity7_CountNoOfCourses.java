package Activity7_CountNoOfCourses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7_CountNoOfCourses 
{
    @Test
    public void countCourses() throws InterruptedException 
    {
        WebDriver driver = new FirefoxDriver();
        try 
        {
            driver.get("https://alchemy.hguy.co/lms");
            WebElement allCoursesLink = driver.findElement(By.linkText("All Courses"));
            allCoursesLink.click();
            Thread.sleep(2000);
            List<WebElement> courses = driver.findElements(By.cssSelector(".ld_course_grid"));
            System.out.println("Number of courses on the page: " + courses.size());
        } 
        finally 
        {
            driver.quit();
        }
    }
}

