package package1;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SwipeExample extends LocalDriverMethod {

    private static Object PointOption;

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = LocalDriverMethod.capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        Thread.sleep(2000);
        //driver.findElementByAccessibilityId("9").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        Thread.sleep(2000);
        TouchAction touchAction = new TouchAction(driver);
        //long press //on element//2 sec///move to another element and then you release element
        WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(first)).withDuration(Duration.ofSeconds(2000))).moveTo(ElementOption.element(second)).release().perform();
        driver.quit();


    }
}
