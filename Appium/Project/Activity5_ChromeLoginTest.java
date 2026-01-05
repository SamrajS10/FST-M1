package Activity5_ChromeLoginTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;

public class Activity5_ChromeLoginTest {
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
    public void validLogin() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"Login Form\")")).click();

        driver.findElement(AppiumBy.id("username")).sendKeys("admin");
        driver.findElement(AppiumBy.id("password")).sendKeys("password");
        driver.findElement(AppiumBy.id("submit")).click();

        String message = driver.findElement(AppiumBy.id("action-confirmation")).getText();
        Assert.assertTrue(message.contains("logged in"));
    }

    @Test
    public void invalidLogin() {
        driver.findElement(AppiumBy.id("username")).clear();
        driver.findElement(AppiumBy.id("username")).sendKeys("wronguser");
        driver.findElement(AppiumBy.id("password")).clear();
        driver.findElement(AppiumBy.id("password")).sendKeys("wrongpass");
        driver.findElement(AppiumBy.id("submit")).click();

        String message = driver.findElement(AppiumBy.id("action-confirmation")).getText();
        Assert.assertTrue(message.contains("invalid"));
    }
}

