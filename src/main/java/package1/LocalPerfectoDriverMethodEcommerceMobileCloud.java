package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocalPerfectoDriverMethodEcommerceMobileCloud {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("app", "PUBLIC:/General-Store.apk");
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("manufacturer", "Samsung");
        //capabilities.setCapability("model", "galaxy s20 ultra");
        capabilities.setCapability("model", "Galaxy .*");
        // capabilities.setCapability("model", "Galaxy S6");
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI5MjIzOWFkNi1iNzQ5LTQ3MWMtOGM4ZS0wYWRkYTVkODZmNjMifQ.eyJpYXQiOjE2NDE0OTUxMDEsImp0aSI6ImQ4ZTQ1ODM4LWJjODgtNDMzZS1hNzhmLTIxMzUyYzZjMGY1OSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvbW9iaWxlY2xvdWQtcGVyZmVjdG9tb2JpbGUtY29tIiwiYXVkIjoiaHR0cHM6Ly9hdXRoLnBlcmZlY3RvbW9iaWxlLmNvbS9hdXRoL3JlYWxtcy9tb2JpbGVjbG91ZC1wZXJmZWN0b21vYmlsZS1jb20iLCJzdWIiOiI3ZmViY2UxNi0zZjFjLTQ1YWMtODU4YS0yN2Y2NWRkNWZhM2MiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJub25jZSI6IjU5MjQ4ZDljLWVlNzYtNDExMC04YmMwLTg5Njk1OWNjODRjOSIsInNlc3Npb25fc3RhdGUiOiI1ZTk2ZmVlZC05YTkzLTRkZDUtODg1OS1kYzI1MDQyNTFjMDYiLCJzY29wZSI6Im9wZW5pZCBvZmZsaW5lX2FjY2VzcyJ9.6emx-BtYpNxSb8FFPIHTl98PDvO8zK4bxp8dNsH_2aI");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        capabilities.setCapability("takeScreenshot", true);
       // capabilities.setCapability("useVirtualDevice", true);
//        capabilities.setCapability("report.projectName", "General Store Sneaker Checkout Scenario");
//        capabilities.setCapability("report.jobName", "myEcommerceJob");
//        capabilities.setCapability("report.JobBranch", "Developer");
//        capabilities.setCapability("report.tags", "penn, appium, android");
        String executionId = (String) capabilities.getCapability("executionID");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://mobilecloud.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
