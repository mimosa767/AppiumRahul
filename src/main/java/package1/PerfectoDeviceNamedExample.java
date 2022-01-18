package package1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class PerfectoDeviceNamedExample {
    public static void main(String[] args) throws MalformedURLException {
        RemoteWebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "3356423251463098");
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("app", "PUBLIC:/ApiDemos-debug.apk");
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2MzM2MDc5MDYsImp0aSI6IjFhOGMwM2RmLTUyMGUtNGIwYi05NjQxLTRmMTdkOWY0YzczYiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDQyMTczM2MtOTFjOC00YzIxLTgxZmItZmM3OWFlNzRjZmQwIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJkY2ZhMDc5Ni05ZWJhLTQxYmYtOThhNi1hODJkMGNlMjAzZWMiLCJzZXNzaW9uX3N0YXRlIjoiYThmNDI0YzktYTM4OC00MmU3LWE3OWUtY2JmNDI1MWRjOWU5Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.azZ-UFTSrrNEVeVUbB7yHjBwd43gJfk3j9zDVAoZ3tI");
        

        driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.quit();


    }
}
