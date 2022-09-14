package package1;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocalPerfectoDriverMethodEcommerceWinnDixieBackup {

    public static IOSDriver capabilities() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //capabilities.setCapability("app", "PUBLIC:/General-Store.apk");
        capabilities.setCapability("bundleId", "com.biloholdings.mywinndixie.prod");
        //capabilities.setCapability("enableAppiumBehavior", true);
       //capabilities.setCapability("deviceSessionId","5789e16c-a758-43dd-901b-5272b99345ec");
        //capabilities.setCapability("deviceName", "9887E8424E31504B58");
        capabilities.setCapability("deviceName", "00008101-000979000291001E");
       // capabilities.setCapability("deviceName", "00008101-000979000291001E");
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
        IOSDriver driver = new IOSDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
       // AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
