package zcompetition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import package1.LocalDriverMethodEcommerce;

import java.net.MalformedURLException;

@Test
public class BrowserStackEcommerce_TestCase_1 extends BrowserStackDriverMethodEcommerce {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = BrowserStackDriverMethodEcommerce.cloudCapabilities();
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
