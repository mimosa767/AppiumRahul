package package1;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PerfectoReportiumEx {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        RemoteWebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("manufacturer", "Samsung");
        capabilities.setCapability("model", "Galaxy N.*");
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("app", "PUBLIC:/ApiDemos-debug.apk");
        capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2MzM2MDc5MDYsImp0aSI6IjFhOGMwM2RmLTUyMGUtNGIwYi05NjQxLTRmMTdkOWY0YzczYiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDQyMTczM2MtOTFjOC00YzIxLTgxZmItZmM3OWFlNzRjZmQwIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJkY2ZhMDc5Ni05ZWJhLTQxYmYtOThhNi1hODJkMGNlMjAzZWMiLCJzZXNzaW9uX3N0YXRlIjoiYThmNDI0YzktYTM4OC00MmU3LWE3OWUtY2JmNDI1MWRjOWU5Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.azZ-UFTSrrNEVeVUbB7yHjBwd43gJfk3j9zDVAoZ3tI");


        driver = new RemoteWebDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Stephen's Project", "1.0"))
                .withJob(new Job("Job name", 1))
                .withContextTags("Stephen tag1", "Penn tag2")
                .withWebDriver(driver)
                .build();
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
        try {
            Thread.sleep(10000);
            reportiumClient.testStart("Stephens Perfecto appium scenario", new TestContext("Stephenz tag", "Pennz tag"));
            reportiumClient.stepStart("App is launched and start first step");
            System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Preference']").isDisplayed());
            boolean successful = driver.findElementByXPath("//android.widget.TextView[@text='Preference']").isDisplayed();
            if (successful == true) {
                reportiumClient.reportiumAssert("Preference is displayed", true);
                driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
                Thread.sleep(3000);
            } else {
                reportiumClient.reportiumAssert("Preference is displayed", false);
            }
            reportiumClient.stepEnd();
            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception ex) {
            reportiumClient.testStop(TestResultFactory.createFailure(ex.getMessage(), ex));
            ex.printStackTrace();
        }

        driver.quit();
        // Retrieve the URL to the DigitalZoom Report
        String reportURL = reportiumClient.getReportUrl();
        System.out.println(reportURL);
    }
}
