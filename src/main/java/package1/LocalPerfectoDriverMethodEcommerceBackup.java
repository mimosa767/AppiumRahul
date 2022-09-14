package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocalPerfectoDriverMethodEcommerceBackup {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("app", "PUBLIC:/General-Store.apk");
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("manufacturer", "Samsung");
        capabilities.setCapability("model", "galaxy s22 ultra");
        //capabilities.setCapability("model", "Galaxy .*");
        // capabilities.setCapability("model", "Galaxy S6");
        capabilities.setCapability("securityToken", "");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        capabilities.setCapability("takeScreenshot", true);
       // capabilities.setCapability("useVirtualDevice", true);
//        capabilities.setCapability("report.projectName", "General Store Sneaker Checkout Scenario");
//        capabilities.setCapability("report.jobName", "myEcommerceJob");
//        capabilities.setCapability("report.JobBranch", "Developer");
//        capabilities.setCapability("report.tags", "penn, appium, android");
        String executionId = (String) capabilities.getCapability("executionID");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
