package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocalPerfectoDriverMethodEcommerceVystarAndroid {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //capabilities.setCapability("app", "PUBLIC:/General-Store.apk");
        capabilities.setCapability("appPackage", "org.vystarcu.vystar");
        capabilities.setCapability("enableAppiumBehavior", true);
       // capabilities.setCapability("deviceSessionId","0d38f456-5125-49f6-8e13-0fdab2c11352");
        //capabilities.setCapability("deviceName", "9887E8424E31504B58");
        capabilities.setCapability("deviceName", "R3CT20BNLKW");
       // capabilities.setCapability("platformVersion", "7.0");
        //capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "6.0.1");
        //capabilities.setCapability("manufacturer", "Samsung");
        //capabilities.setCapability("model", "galaxy s20 ultra");
       // capabilities.setCapability("model", "Galaxy S8.*");
        // capabilities.setCapability("model", "Galaxy S6");
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2NTc1NjMyODAsImp0aSI6IjZiZTBkMTY0LWEzODMtNGUwZC1iYmJjLWM0YjJiZjBmNTg0YyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiNjEwM2FhZjktOTdkNC00YjgwLThmZTYtZDNhYmRlNTJhM2JiIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIwNGM3YzA2Yi02MTVhLTRhZGUtOGYwZi1jMTUzZDdmYWRiYjYiLCJzZXNzaW9uX3N0YXRlIjoiNjM3ZGQyNTEtNWI3ZS00NTlkLTk5MDgtZDY3ZWZhYmE5YjEzIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.guCb3NHpOboo1SGBE93gp2w0uknKl7D6jrCDUmw-YGQ");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        capabilities.setCapability("takeScreenshot", true);
       // capabilities.setCapability("location", "NA-US-BOS");
       // capabilities.setCapability("resolution", "1440X2960");
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
