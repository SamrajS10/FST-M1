package Activity6_ChromePopupTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;

public class Activity6_ChromePopupTest {
    AndroidDriver driver;

    @Test
    public void popupLogin() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements");

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"Popups\")")).click();

        driver.findElement(AppiumBy.id("popupButton")).click(); // Replace
        driver.findElement(AppiumBy.id("username")).sendKeys("admin"); // Replace
        driver.findElement(AppiumBy.id("password")).sendKeys("password"); // Replace
        driver.findElement(AppiumBy.id("submit")).click(); // Replace

        String message = driver.findElement(AppiumBy.id("action-confirmation")).getText(); // Replace
        Assert.assertTrue(message.contains("logged in"));
    }
}

