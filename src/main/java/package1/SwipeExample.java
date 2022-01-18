package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SwipeExample extends LocalDriverMethod {

    public static void main (String [] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = LocalDriverMethod.capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();



    }
}
