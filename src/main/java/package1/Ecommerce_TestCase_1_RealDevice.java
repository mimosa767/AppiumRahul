package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class Ecommerce_TestCase_1_RealDevice extends LocalDriverMethodRealDevice {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = LocalDriverMethodRealDevice.capabilities();
        Thread.sleep(2000);
        //driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
        //Thread.sleep(2000);
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
