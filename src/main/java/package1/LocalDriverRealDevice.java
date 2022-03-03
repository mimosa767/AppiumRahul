package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LocalDriverRealDevice extends LocalDriverMethodRealDevice {

    public static void main (String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = LocalDriverMethodRealDevice.capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.CheckBox[@resource-id='android:id/checkbox']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        Thread.sleep(2000);
        driver.findElementsByClassName("android.widget.Button").get(1).click();
        Thread.sleep(2000);
        driver.quit();


    }

}
