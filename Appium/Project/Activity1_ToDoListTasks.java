package Activity1_ToDoListTasks;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1_ToDoListTasks {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("/path/to/todolist.apk");  // Change to your APK path
        options.noReset();

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void addTasks() {
        String[] tasks = {
                "Complete Activity 1 with priority high",
                "Complete Activity 2 with priority medium",
                "Complete Activity 3 with priority low"
        };

        for (String task : tasks) {
            driver.findElement(AppiumBy.accessibilityId("Add Task")).click(); // Example
            driver.findElement(AppiumBy.id("task_input")).sendKeys(task);
            driver.findElement(AppiumBy.id("save_button")).click();
        }

        List<WebElement> taskList = driver.findElements(AppiumBy.id("task_title"));
        Assert.assertEquals(taskList.size(), 3, "All tasks should be added");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
