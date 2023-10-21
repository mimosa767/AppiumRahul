package package1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.perfecto.utilities.device.DeviceLogs;
import com.perfecto.utilities.device.DeviceVitals;
import com.perfecto.utilities.device.Location;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Ecommerce_TestCase_1b_PerfectoReportiumExSmartReportingAPITrial extends LocalPerfectoDriverMethodEcommerceTrial {
    //setCustomConditions(driver);
    //Network Virtualization; startNetworkVirtualization(driver, "1");
    // enableAirplaneMode(driver);
    //  disableWifi(driver);
    public static void main (String [] args) throws IOException, InterruptedException, URISyntaxException {

        final String PERFECTO_SECURITY_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2NTc1NjMyODAsImp0aSI6IjZiZTBkMTY0LWEzODMtNGUwZC1iYmJjLWM0YjJiZjBmNTg0YyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiNjEwM2FhZjktOTdkNC00YjgwLThmZTYtZDNhYmRlNTJhM2JiIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIwNGM3YzA2Yi02MTVhLTRhZGUtOGYwZi1jMTUzZDdmYWRiYjYiLCJzZXNzaW9uX3N0YXRlIjoiNjM3ZGQyNTEtNWI3ZS00NTlkLTk5MDgtZDY3ZWZhYmE5YjEzIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.guCb3NHpOboo1SGBE93gp2w0uknKl7D6jrCDUmw-YGQ"; // TODO put your security token here
        final String SECURITY_TOKEN = System.getProperty("security-token", PERFECTO_SECURITY_TOKEN);

        // The Perfecto Continuous Quality Lab you work with
        final String CQL_NAME = System.getProperty("CQL_NAME", "demo"); // TODO put your Continuous Quality Lab name here
        final String REPORTING_SERVER_URL = "https://" + CQL_NAME + ".reporting-01.perfectomobile.com";
        final String CQL_SERVER_URL = "https://" + CQL_NAME + ".perfectomobile.com";
        final String OFFLINE_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE2NTc1NjMyODAsImp0aSI6IjZiZTBkMTY0LWEzODMtNGUwZC1iYmJjLWM0YjJiZjBmNTg0YyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiNjEwM2FhZjktOTdkNC00YjgwLThmZTYtZDNhYmRlNTJhM2JiIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIwNGM3YzA2Yi02MTVhLTRhZGUtOGYwZi1jMTUzZDdmYWRiYjYiLCJzZXNzaW9uX3N0YXRlIjoiNjM3ZGQyNTEtNWI3ZS00NTlkLTk5MDgtZDY3ZWZhYmE5YjEzIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MifQ.guCb3NHpOboo1SGBE93gp2w0uknKl7D6jrCDUmw-YGQ";
        String network = "4g_lte_advanced_average";
        AndroidDriver<AndroidElement> driver = LocalPerfectoDriverMethodEcommerceTrial.capabilities();
        Thread.sleep(500);
        //create a PerfectoExecutionContext instanceIphone12promax00008101-000979000291001EwDeviceVitals
        //The execution context defines metadata for the Execution report. The metadata includes "tags" that can be used to select the exection
        //report from the list of reports
        //A single Execution report may include multiple test reports
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Ecommerce Purchase Scenario", "3"))
                        .withJob( new Job("Purchase Sneaker Checkout Flow", 1))
                                .withContextTags("Sanity", "Penn", "Ecommerce Purchase Feature", "Regression", "Smoke", "Android", "2.0", "Shop")
                                        .withWebDriver(driver)
                                                .build();
        //The ReportiumClient monitors the application and transfers the report information and artifacts to the Reporting storage server
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
        try {
            Thread.sleep(500);
            reportiumClient.testStart("Scroll through cart and make a purchase - 4G LTE advanced_average", new TestContext("\"Sanity\", \"Smoke\""));//notify reportiumClient that the test is starting
            reportiumClient.stepStart("This is the pre-steps to start all relevant diagnostics");///define the logical step of the test that includes one or more actual command steps in the automation script but delineate a logical sequence of command steps
            Location.setDeviceLocationByAddress(driver, "2695 Glenvalley Drive, Decatur GA 30032");
            startNetworkVirtualization(driver,"4g_lte_advanced_average");
            DeviceVitals.startDeviceVitals(driver, 5);
            DeviceLogs.startDeviceLogs(driver);
            reportiumClient.stepEnd();
            reportiumClient.stepStart("App is launched, log in and other details are selected");
            System.out.println(driver.getPageSource());
            driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Stephen is here");
            Thread.sleep(500);
            driver.hideKeyboard();
            Thread.sleep(500);
            driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
            Thread.sleep(500);
            driver.findElementById("android:id/text1").click();
            Thread.sleep(500);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
            driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
            driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
            reportiumClient.stepEnd("Finished first screen");

            reportiumClient.stepStart("Scroll through sneakers, and put into cart");
            getAccessibiltyReport(driver);
            updateNetworkVirtualization(driver, "2g_gprs_poor");
            Thread.sleep(500);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
            System.out.println("the size is " + driver.findElementsById("com.androidsample.generalstore:id/productName").size());
            int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
            System.out.println("This is the count " + count);
            for (int i = 0; i < count; i++) {
                System.out.println("i is " + i);
                String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
                System.out.println("this is the text " + text);
                if (Objects.equals(text, "Jordan 6 Rings")) {
                    reportiumClient.stepEnd();
                    reportiumClient.reportiumAssert("the correct Shoes were selected", true);
                    System.out.println("working if");
                    driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                    break; //no need to iterate once we find the link were looking for
                } else {
                    reportiumClient.reportiumAssert("The shoes were not put into the cart successfully", false);
                }

            }
            getNetworkSettings(driver);
            Thread.sleep(500);
            reportiumClient.stepStart("Begin the add to cart");
            driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
            Thread.sleep(500);
            String lastPageText = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
            Thread.sleep(500);
            System.out.println("This is the lastPageText " + lastPageText);
            Assert.assertEquals("Jordan 6 Rings", lastPageText);
            reportiumClient.reportiumAssert("The correct shoe was priced", true);
            reportiumClient.stepEnd();
            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception ex) {
            reportiumClient.testStop(TestResultFactory.createFailure(ex.getMessage(), ex));//stop the test by notifying the reporting client that the test unit has completed and provide a status for the test completion
            ex.printStackTrace();
        }
        DeviceVitals.stopDeviceVitals(driver);
        stopNetworkVirtualization(driver);
        DeviceLogs.stopDeviceLogs(driver);
        DeviceLogs.getDeviceLogs(driver, 5);
        Thread.sleep(500);
        driver.quit();
        String reportURL = reportiumClient.getReportUrl();//the reporting client can supply the URL to the report for retrieval, the report takes time because the different components needs to be compiled
        System.out.println(reportURL);


    }

    // To start network virtualization
    public static void startNetworkVirtualization(AppiumDriver driver, String networkProfile) {
        Map<String, Object> params = new HashMap<>();
        params.put("profile", networkProfile);
        params.put("generateHarFile", "true");
        driver.executeScript("mobile:vnetwork:start", params);
    }
    // To stop network virtualization
    public static void stopNetworkVirtualization(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("pcapFile", "true");
        driver.executeScript("mobile:vnetwork:stop", params);
    }
    // To update network virtualization
    public static void updateNetworkVirtualization(AppiumDriver driver, String networkProfile) {
        Map<String, Object> params = new HashMap<>();
        params.put("profile", networkProfile);
        driver.executeScript("mobile:vnetwork:update", params);
    }
    // To enable Airplane Mode on Android versions less than 7
    public static void enableAirplaneMode(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("airplanemode", "enabled");
        driver.executeScript("mobile:network.settings:set", params);
    }
    // To disable Wifi
    public static void disableWifi(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("wifi", "disabled");
        driver.executeScript("mobile:network.settings:set", params);
    }
    // To set custom network conditions
    public static void setCustomConditions (AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("packetLoss", "5");
        params.put("latency", "1200");
        params.put("bandwidth.in", "50000");
        params.put("bandwidth.out", "50000");
        driver.executeScript("mobile:vnetwork:start", params);
    }
    // To get the current network settings
    public static void getNetworkSettings (AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("property", "wifi");
        driver.executeScript("mobile:network.settings:get", params);
    }
    //To get an accessibility report
    public static void getAccessibiltyReport(AppiumDriver driver){
        Map<String, Object> params = new HashMap<>();
        params.put("tag", "audited-shoppingcart-screen-1");
        driver.executeScript("mobile:checkAccessibility:audit", params);
    }
}