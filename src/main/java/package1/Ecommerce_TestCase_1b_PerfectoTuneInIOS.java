package package1;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class Ecommerce_TestCase_1b_PerfectoTuneInIOS extends LocalPerfectoDriverMethodEcommerceTuneInIOS {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {
        IOSDriver driver = LocalPerfectoDriverMethodEcommerceTuneInIOS.capabilities();
        Thread.sleep(10000);
        String network = "4g_lte_advanced_good";
        //Location.setDeviceLocationByAddress(driver, "2695 Glenvalley Drive, Decatur GA 30032");
        //startNetworkVirtualization(driver, network);
        //create a PerfectoExecutionContext instance
        //The execution context defines metadata for the Execution report. The metadata includes "tags" that can be used to select the execution
        //report from the list of reports
        //A single execution report may include multiple test reports
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("TuneInIOS Demo", "1"))
                .withJob(new Job("TuneInIOS Job", 1))
                .withContextTags("Android", "Penn", "Ecommerce", "Regression", "Smoke")
                .withWebDriver(driver)
                .build();
        //The ReportiumClient monitors the application and transfers the report information and artifacts to the Reporting storage server
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
        try {
            Thread.sleep(5000);
            reportiumClient.testStart("TuneInIOS Job", new TestContext("\"Sanity\", \"Smoke\", \"Penn\""));//notify reportiumClient that the test is starting
            Thread.sleep(500);
            Thread.sleep(500);
            reportiumClient.stepStart("App is launched and the first steps begins");///define the logical step of the test that includes one or more actual command steps in the automation script but delineate a logical sequence of command steps
            Thread.sleep(1000);
            driver.findElementByXPath("//*[@name=\"Local Radio\"]").click();
            Thread.sleep(10000);
            driver.findElementByXPath("//XCUIElementTypeAlert/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");
            Thread.sleep(1000);
            driver.findElementByXPath("//XCUIElementTypeTable/XCUIElementTypeCell[1]").click();
            Thread.sleep(1000);
            Thread.sleep(10000);
            Thread.sleep(5000);
            driver.findElementByXPath("//*[@label=\"Play\"]").click();
            Thread.sleep(50000);
            driver.findElementByXPath("//*[@label=\"Options\"]").click();
            Thread.sleep(10000);
        } catch (Exception ex) {
            reportiumClient.testStop(TestResultFactory.createFailure(ex.getMessage(), ex));//stop the test by notifying the reporting client that the test unit has completed and provide a status for the test completion
            ex.printStackTrace();
        }
            Thread.sleep(500);
          //  stopNetworkVirtualization(driver);
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

    //To get an accessibility report
    public static void getAccessibiltyReport(AppiumDriver driver){
        Map<String, Object> params = new HashMap<>();
        params.put("tag", "audited-shoppingcart-screen-1");
        driver.executeScript("mobile:checkAccessibility:audit", params);
    }

    }

