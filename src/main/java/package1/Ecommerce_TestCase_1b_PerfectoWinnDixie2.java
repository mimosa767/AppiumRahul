package package1;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class Ecommerce_TestCase_1b_PerfectoWinnDixie2 extends LocalPerfectoDriverMethodEcommerceWinnDixie {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {
        IOSDriver driver = LocalPerfectoDriverMethodEcommerceWinnDixie.capabilities();
        Thread.sleep(10000);
        String network = "4g_lte_advanced_good";
        startNetworkVirtualization(driver, network);
        //create a PerfectoExecutionContext instance
        //The execution context defines metadata for the Execution report. The metadata includes "tags" that can be used to select the execution
        //report from the list of reports
        //A single execution report may include multiple test reports
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Winn-Dixie Demo", "1"))
                .withJob(new Job("Winn-Dixie Job", 1))
                .withContextTags("Android", "Penn", "Winn-Dixie", "Regression", "Smoke")
                .withWebDriver(driver)
                .build();
        //The ReportiumClient monitors the application and transfers the report information and artifacts to the Reporting storage server
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
        try {
            reportiumClient.testStart("Winn-Dixie Job", new TestContext("\"Sanity\", \"Smoke\", \"Winn-Dixie\""));//notify reportiumClient that the test is starting
            Thread.sleep(2000);
            reportiumClient.stepStart("App is launched and the first steps begins");///define the logical step of the test that includes one or more actual command steps in the automation script but delineate a logical sequence of command steps
            Thread.sleep(2000);
//            Map<String, Object> params6 = new HashMap<>();
//            params6.put("label", "Dismiss");
//            driver.executeScript("mobile:button-text:click", params6);
//            Thread.sleep(2000);
            Map<String, Object> params = new HashMap<>();params.put("label", "Get started");driver.executeScript("mobile:button-text:click", params);
            Thread.sleep(2000);
                Map<String, Object> params2 = new HashMap<>();
                params2.put("label", "Phone Number or Email Address");
                params2.put("text", "spenn6@gmail.com");
                params2.put("timeout", "20");params2.put("screen.top", "58%");
                params2.put("screen.left", "0%");
                params2.put("screen.width", "100%");
                params2.put("screen.height", "8%");
                driver.executeScript("mobile:edit-text:set", params2);
            Thread.sleep(2000);
            Map<String, Object> params3 = new HashMap<>();params3.put("label", "SIGN IN");params3.put("timeout", "20");params3.put("screen.top", "40%");params3.put("screen.left", "0%");params3.put("screen.width", "100%");params3.put("screen.height", "13%");driver.executeScript("mobile:button-text:click", params3);
            Thread.sleep(3000);
            Map<String, Object> params4 = new HashMap<>();
            params4.put("label", "Password");
            params4.put("text", "Password123!");
            params4.put("timeout", "20");
            params4.put("screen.top", "57%");
            params4.put("screen.left", "0%");
            params4.put("screen.width", "100%");
            params4.put("screen.height", "9%");
            driver.executeScript("mobile:edit-text:set", params4);
            Thread.sleep(3000);
            Map<String, Object> params5 = new HashMap<>();params5.put("label", "SIGN IN");params5.put("timeout", "20");params5.put("screen.top", "51%");params5.put("screen.left", "0%");params5.put("screen.width", "100%");params5.put("screen.height", "11%");driver.executeScript("mobile:button-text:click", params5);
            Thread.sleep(2000);
            Thread.sleep(2000);
            reportiumClient.reportiumAssert("The flow finished as expected", true);
            reportiumClient.stepEnd();
            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception ex) {
            reportiumClient.testStop(TestResultFactory.createFailure(ex.getMessage(), ex));//stop the test by notifying the reporting client that the test unit has completed and provide a status for the test completion
            ex.printStackTrace();
        }
            Thread.sleep(500);
            stopNetworkVirtualization(driver);
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

