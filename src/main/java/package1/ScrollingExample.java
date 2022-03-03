package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ScrollingExample extends LocalDriverMethod {

    public static void  main (String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = LocalDriverMethod.capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Thread.sleep(2000);
        //scroll several screens to the webview element
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
        Thread.sleep(2000);
        driver.quit();
    }
}
