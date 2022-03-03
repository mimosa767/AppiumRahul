package package1;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragDropExample extends LocalDriverMethod {

    public static void main (String [] args) throws InterruptedException, MalformedURLException {

        AndroidDriver<AndroidElement> driver = LocalDriverMethod.capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@content-desc='Drag and Drop']").click();
        Thread.sleep(2000);
        TouchAction touchAction = new TouchAction(driver);
        WebElement source = driver.findElementByXPath("//android.view.View[@index='1']");
        WebElement destination = driver.findElementByXPath("//android.view.View[@index='2']");
        //touchAction.longPress(LongPressOptions.longPressOptions().withElement(new ElementOption().withElement(source))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1000))).moveTo(new ElementOption().withElement(destination)).release().perform();
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(new ElementOption().withElement(source))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(new ElementOption().withElement(destination)).release().perform();
        Thread.sleep(2000);
        driver.quit();
    }
}
