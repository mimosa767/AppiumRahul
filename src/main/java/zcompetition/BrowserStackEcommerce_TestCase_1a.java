package zcompetition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import package1.LocalDriverMethodEcommerce;

import java.net.MalformedURLException;

@Test
public class BrowserStackEcommerce_TestCase_1a extends BrowserStackDriverMethodEcommerce {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = BrowserStackDriverMethodEcommerce.cloudCapabilities();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/text1").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        Thread.sleep(2000);
        // name attribute for toast messages will have the content
        String toastMessage =  driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println(toastMessage);
        Assert.assertEquals("Please enter your name", toastMessage); //Actual validation
        driver.quit();

    }
}
