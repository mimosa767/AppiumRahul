package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocalPerfectoDriverMethodEcommerce {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "PUBLIC:/General-Store.apk");
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("platformVersion", ".*");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("manufacturer", "Samsung");
        capabilities.setCapability("model", "Galaxy S22 Ultra");
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2NDU4MDI1OTMsImp0aSI6ImU1NTJiZWVlLTY3OTItNDc3Mi1hNzNjLTRlMjNhMGY4ZDgwNSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDQyMTczM2MtOTFjOC00YzIxLTgxZmItZmM3OWFlNzRjZmQwIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIzNGM0MzljNC0xOGMxLTRhZDktYmFjZS0yZDdiMjlkNTUxYjUiLCJzZXNzaW9uX3N0YXRlIjoiMzc3NzY1M2QtYzhiNy00MWY3LWFmMWQtNzA3YTVkNzc3MGM2Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.pwkicVBa05D-vizMWs3dCp3bCM8p9VNTvDQUDQCa6tY");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        capabilities.setCapability("takeScreenshot", true);
        String executionId = (String) capabilities.getCapability("executionID");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
