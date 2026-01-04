package Activity1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 
{

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException 
    {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("path/to/calculator.apk"); 
        options.noReset();
        URL serverURL = new URL("http://localhost:4723");


        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void multiplyTest() 
    {

        // Click number 5
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();

        // Click multiplication (*)
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();

        // Click number 8
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_8")).click();

        // Click equals (=)
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        // Get the result
        String result = driver
                .findElement(AppiumBy.id("com.android.calculator2:id/result"))
                .getText();
        Assert.assertEquals(result, "40", "Multiplication result is incorrect");
    }

    @AfterClass
    public void tearDown() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }
}
