package zcompetition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class SingleBrowserStackEcommerce_TestCase_1  {

    //public static void main (String [] args) throws MalformedURLException, InterruptedException {
        @Test
        public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Google Pixel 4");
        capabilities.setCapability("os_version", "10.0");
        capabilities.setCapability("browserstack.user", "stephen_tvdlr3");
        capabilities.setCapability("browserstack.key", "mXJMiLMAFxB74gJqUqUX");
        capabilities.setCapability(MobileCapabilityType.APP, "bs://912009aba23cc74dc5b0b0caa1c6a1a06747cabe"); //uploaded apk to browser stack repository and was provided a URL
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        capabilities.setCapability("browserstack.networkLogs", true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Stephen is here");
        Thread.sleep(2000);
        driver.hideKeyboard();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/text1").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        Thread.sleep(2000);
        driver.quit();

    }
}
