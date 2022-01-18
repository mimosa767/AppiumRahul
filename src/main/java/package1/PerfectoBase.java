package package1;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PerfectoBase {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        RemoteWebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("manufacturer", "Samsung");
        capabilities.setCapability("model", "Galaxy.*");
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("app", "PUBLIC:/ApiDemos-debug.apk");
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2MzM2MDc5MDYsImp0aSI6IjFhOGMwM2RmLTUyMGUtNGIwYi05NjQxLTRmMTdkOWY0YzczYiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDQyMTczM2MtOTFjOC00YzIxLTgxZmItZmM3OWFlNzRjZmQwIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJkY2ZhMDc5Ni05ZWJhLTQxYmYtOThhNi1hODJkMGNlMjAzZWMiLCJzZXNzaW9uX3N0YXRlIjoiYThmNDI0YzktYTM4OC00MmU3LWE3OWUtY2JmNDI1MWRjOWU5Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.azZ-UFTSrrNEVeVUbB7yHjBwd43gJfk3j9zDVAoZ3tI");


        driver = new RemoteWebDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(7000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(7000);
        driver.quit();


    }
}
