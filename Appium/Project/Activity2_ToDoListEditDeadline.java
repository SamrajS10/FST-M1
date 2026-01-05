package Activity2_ToDoListEditDeadline;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;

public class Activity2_ToDoListEditDeadline {
    AndroidDriver driver;

    @Test
    public void editTaskDeadline() {
        WebElement firstTask = driver.findElement(AppiumBy.id("task_title")); // Replace
        new TouchAction(driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(firstTask))
                        .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();

        driver.findElement(AppiumBy.id("deadline_input")).sendKeys("Next Saturday"); // Replace
        driver.findElement(AppiumBy.id("save_button")).click(); // Replace

        String deadline = driver.findElement(AppiumBy.id("task_deadline")).getText(); // Replace
        Assert.assertTrue(deadline.contains("Saturday"), "Deadline should be set");
    }
}

