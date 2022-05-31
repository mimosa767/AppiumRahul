package package1;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.perfecto.utilities.device.Location;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ecommerce_TestCase_1b_PerfectoAlta extends LocalPerfectoDriverMethodEcommerceAlta {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = LocalPerfectoDriverMethodEcommerceAlta.capabilities();
        Thread.sleep(1000);
        String network = "4g_lte_advanced_average";
        //Location.setDeviceLocationByAddress(driver, "2695 Glenvalley Drive, Decatur GA 30032");
        //startNetworkVirtualization(driver, network);
        //create a PerfectoExecutionContext instance
        //The execution context defines metadata for the Execution report. The metadata includes "tags" that can be used to select the execution
        //report from the list of reports
        //A single execution report may include multiple test reports
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Volta Charging Stations Demo", "1"))
                .withJob(new Job("Volta Charging Station Job", 1))
                .withContextTags("Android", "Penn", "Ecommerce", "Regression", "Smoke")
                .withWebDriver(driver)
                .build();
        //The ReportiumClient monitors the application and transfers the report information and artifacts to the Reporting storage server
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
        try {
            Thread.sleep(500);
            reportiumClient.testStart("Volta Charging Station Job", new TestContext("\"Sanity\", \"Smoke\", \"Penn\""));//notify reportiumClient that the test is starting
            reportiumClient.stepStart("App is launched and the first steps begins");///define the logical step of the test that includes one or more actual command steps in the automation script but delineate a logical sequence of command steps
            Thread.sleep(500);
            driver.findElementByXPath("//*[@text=\"Continue with Email\"]").click();
            Thread.sleep(500);
            driver.findElementByXPath("//*[@content-desc=\"create_email\"]").sendKeys("spenn6@gmail.com");
            Thread.sleep(500);
            driver.findElementByXPath("//*[@content-desc=\"create_password\"]").sendKeys("Alexander1463!");
            Thread.sleep(500);
            driver.findElementByXPath("//*[@class=\"android.widget.ScrollView\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]").click();
            Thread.sleep(500);
            getAccessibiltyReport(driver);
            driver.findElementByXPath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]").click();
            Thread.sleep(500);
            driver.findElementByXPath("//*[@content-desc=\"map_search_input\"]").click();
            Thread.sleep(500);
            driver.findElementByXPath("//*[@content-desc=\"map_search_input\"]").sendKeys("2695 Glenvalley Drive, Decatur GA 30032");
            Thread.sleep(500);
            driver.findElementByXPath("//*[@resource-id=\"search_drawer\"]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[2]").click();
            Thread.sleep(500);
            driver.findElementByXPath("//*[@text=\"Google\"]").click();
            System.out.println("Success");
        } catch (Exception ex) {
            reportiumClient.testStop(TestResultFactory.createFailure(ex.getMessage(), ex));//stop the test by notifying the reporting client that the test unit has completed and provide a status for the test completion
            ex.printStackTrace();
        }
            Thread.sleep(500);
            //stopNetworkVirtualization(driver);
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

