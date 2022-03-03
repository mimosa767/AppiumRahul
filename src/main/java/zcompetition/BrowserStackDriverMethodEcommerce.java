package zcompetition;




import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BrowserStackDriverMethodEcommerce {

    public static AndroidDriver<AndroidElement> cloudCapabilities() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("browserstack.user", "stephen_tvdlr3");
        capabilities.setCapability("browserstack.key", "mXJMiLMAFxB74gJqUqUX");
        capabilities.setCapability(MobileCapabilityType.APP, "bs://912009aba23cc74dc5b0b0caa1c6a1a06747cabe"); //uploaded apk to browser stack repository and was provided a URL
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        capabilities.setCapability("browserstack.networkLogs", true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
