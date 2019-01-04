import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class androidSampleTest {

    //public AppiumDriver<MobileElement> driver;
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","Nexus 5 API 24");
        caps.setCapability("udid","emulator-5554");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","7.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage","com.veronicaapps.veronica.simplecalculator");
        caps.setCapability("appActivity","com.veronicaapps.veronica.simplecalculator.MainActivity");
        caps.setCapability("noRest","false");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(groups = { "smoketest" })
    public void SampleTest() {

        driver.findElementById("com.veronicaapps.veronica.simplecalculator:id/button_one").click();
        driver.findElementById("com.veronicaapps.veronica.simplecalculator:id/button_plus").click();
        driver.findElementById("com.veronicaapps.veronica.simplecalculator:id/button_two").click();
        driver.findElementById("com.veronicaapps.veronica.simplecalculator:id/button_equals").click();

        String strSum = driver.findElementById("com.veronicaapps.veronica.simplecalculator:id/editText_result").getText().toString();

        System.out.println("The SumTotal is: " + strSum);
    }

    @AfterClass
    public void teardsown(){
        driver.quit();
    }

}