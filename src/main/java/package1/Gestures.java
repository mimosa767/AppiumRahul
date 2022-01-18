package package1;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class Gestures extends LocalDriverMethod {
    public static void main (String [] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = LocalDriverMethod.capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Thread.sleep(2000);
        //Tap
        TouchAction touchAction = new TouchAction(driver);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandList))).perform();
        Thread.sleep(2000);
        //touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandList)).withPosition(PointOption.point()))
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        Thread.sleep(2000);
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        System.out.println("1");
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames)).withDuration(Duration.ofSeconds(2000))).release().perform();
        Thread.sleep(2000);
        System.out.println(driver.findElementByXPath("//android.widget.TextView[@resource-id='android:id/title'](0)").getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
