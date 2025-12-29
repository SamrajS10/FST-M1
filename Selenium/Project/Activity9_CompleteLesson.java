package Activity9_CompleteLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9_CompleteLesson {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void CompleteLesson() {
        // Step a + b: Open browser and navigate
        driver.get("https://alchemy.hguy.co/lms");

        // Step: Login (optional, needed for My Courses)
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Login')]"))).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        System.out.println("Login successful");

        // Step c + d: Navigate to All Courses
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("All Courses"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Step e: Safely select first clickable course
        List<WebElement> courses = driver.findElements(By.xpath(
                "//h2//a[not(contains(@style,'display:none')) and string-length(text())>0] | " +
                "//article//a[not(contains(@style,'display:none')) and string-length(text())>0] | " +
                "//*[contains(@class,'course')]//a[not(contains(@style,'display:none')) and string-length(text())>0]"));

        if (courses.isEmpty()) {
            System.out.println("All courses are already completed or no clickable courses available.");
            throw new SkipException("No clickable courses found.");
        }

        WebElement firstCourse = courses.get(0);
        String courseTitle = firstCourse.getText().trim();

        // Scroll into view and click using JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstCourse);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCourse);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        System.out.println("Opened course: " + courseTitle);

        // Step f: Check if course is completed
        List<WebElement> completionIndicator = driver.findElements(By.xpath(
                "//*[contains(text(),'Completed') or contains(text(),'100%')]"));

        if (completionIndicator.isEmpty()) {
            System.out.println("Course is NOT completed.");
        } else {
            System.out.println("Course is already completed.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
