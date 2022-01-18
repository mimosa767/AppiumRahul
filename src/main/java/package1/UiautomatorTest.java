package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UiautomatorTest extends LocalDriverMethod {

    public static void main  (String[] args) throws InterruptedException, MalformedURLException {
        AndroidDriver<AndroidElement> driver = LocalDriverMethod.capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementByAndroidUIAutomator(("attribute(\"value\")")
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        Thread.sleep(2000);
        //driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
        //Validate clickable feature for all options
        //driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
        driver.quit();

    }

}
