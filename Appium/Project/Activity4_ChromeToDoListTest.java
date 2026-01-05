package Activity4_ChromeToDoListTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity4_ChromeToDoListTest {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements");
    }

    @Test
    public void addTasksAndVerify() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"To-Do List\")")).click();

        String[] tasks = {"Task 1", "Task 2", "Task 3"};
        WebElement inputField = driver.findElement(AppiumBy.id("taskInput")); // Replace
        for (String task : tasks) {
            inputField.sendKeys(task);
            driver.findElement(AppiumBy.id("addTaskButton")).click(); // Replace
        }

        List<WebElement> taskList = driver.findElements(AppiumBy.className("task")); // Replace
        Assert.assertEquals(taskList.size(), 5); // 2 existing + 3 new
    }
}

