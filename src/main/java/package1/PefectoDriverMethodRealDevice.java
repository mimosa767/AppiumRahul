package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PefectoDriverMethodRealDevice {

    public static AndroidDriver capabilities() throws MalformedURLException {
        String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2NDU4MDI1OTMsImp0aSI6ImU1NTJiZWVlLTY3OTItNDc3Mi1hNzNjLTRlMjNhMGY4ZDgwNSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDQyMTczM2MtOTFjOC00YzIxLTgxZmItZmM3OWFlNzRjZmQwIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIzNGM0MzljNC0xOGMxLTRhZDktYmFjZS0yZDdiMjlkNTUxYjUiLCJzZXNzaW9uX3N0YXRlIjoiMzc3NzY1M2QtYzhiNy00MWY3LWFmMWQtNzA3YTVkNzc3MGM2Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.pwkicVBa05D-vizMWs3dCp3bCM8p9VNTvDQUDQCa6tY ";
        AndroidDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("manufacturer", "Samsung");
        capabilities.setCapability("model", "Galaxy N.*");
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("app", "PUBLIC:/General-Store.apk");
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2NDU4MDI1OTMsImp0aSI6ImU1NTJiZWVlLTY3OTItNDc3Mi1hNzNjLTRlMjNhMGY4ZDgwNSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDQyMTczM2MtOTFjOC00YzIxLTgxZmItZmM3OWFlNzRjZmQwIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIzNGM0MzljNC0xOGMxLTRhZDktYmFjZS0yZDdiMjlkNTUxYjUiLCJzZXNzaW9uX3N0YXRlIjoiMzc3NzY1M2QtYzhiNy00MWY3LWFmMWQtNzA3YTVkNzc3MGM2Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.pwkicVBa05D-vizMWs3dCp3bCM8p9VNTvDQUDQCa6tY");


        driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
