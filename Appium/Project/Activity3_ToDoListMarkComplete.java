package Activity3_ToDoListMarkComplete;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3_ToDoListMarkComplete {
    AndroidDriver driver;

    @Test
    public void markTasksComplete() {
        // Mark first two tasks complete
        driver.findElement(AppiumBy.id("task_checkbox_1")).click(); // Replace
        driver.findElement(AppiumBy.id("task_checkbox_2")).click(); // Replace

        // Edit third task progress to 50%
        WebElement thirdTask = driver.findElement(AppiumBy.id("task_title_3")); // Replace
        driver.findElement(AppiumBy.id("task_progress_slider")).sendKeys("50"); // Replace

        driver.findElement(AppiumBy.id("save_button")).click(); // Replace

        driver.findElement(AppiumBy.accessibilityId("Completed tasks")).click(); // Replace

        List<WebElement> completedTasks = driver.findElements(AppiumBy.id("task_title")); // Replace
        Assert.assertEquals(completedTasks.size(), 2, "Only 2 tasks should be completed");
    }
}

