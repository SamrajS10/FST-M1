package Activity6;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException 
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Selenium slider page
        driver.get("https://training-support.net/webelements/sliders");
    }

    @Test
    public void volume75Test() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));

        // Get screen size
        Dimension dims = driver.manage().window().getSize();

        // Start and end points for swipe (50% → 67%)
        Point start = new Point((int) (dims.getWidth() * 0.50), (int) (dims.getHeight() * 0.77));
        Point end = new Point((int) (dims.getWidth() * 0.67), (int) (dims.getHeight() * 0.77));

        // Swipe to 75%
        doSwipe(start, end, 2000);

        // Get slider value
        String volumeText = driver
                .findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
                .getText();

        System.out.println("Volume after swipe 75%: " + volumeText);

        // Assertion
        assertTrue(volumeText.contains("75%"));
    }

    @Test
    public void volume25Test() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
        Dimension dims = driver.manage().window().getSize();

        // Start and end points for swipe (50% → 33%)
        Point start = new Point((int) (dims.getWidth() * 0.50), (int) (dims.getHeight() * 0.77));
        Point end = new Point((int) (dims.getWidth() * 0.33), (int) (dims.getHeight() * 0.77));

        // Swipe to 25%
        doSwipe(start, end, 2000);
        String volumeText = driver
                .findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
                .getText();

        System.out.println("Volume after swipe 25%: " + volumeText);

        assertTrue(volumeText.contains("25%"));
    }

    private void doSwipe(Point start, Point end, int duration) {
        new TouchAction(driver)
                .press(PointOption.point(start))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(end))
                .release()
                .perform();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
