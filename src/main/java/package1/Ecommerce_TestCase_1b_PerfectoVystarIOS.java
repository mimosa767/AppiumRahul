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
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class Ecommerce_TestCase_1b_PerfectoVystarIOS extends LocalPerfectoDriverMethodEcommerceVystarIOS {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {
        IOSDriver driver = LocalPerfectoDriverMethodEcommerceVystarIOS.capabilities();
        Thread.sleep(10000);
        String network = "4g_lte_advanced_good";
        //Location.setDeviceLocationByAddress(driver, "2695 Glenvalley Drive, Decatur GA 30032");
        //startNetworkVirtualization(driver, network);
        //create a PerfectoExecutionContext instance
        //The execution context defines metadata for the Execution report. The metadata includes "tags" that can be used to select the execution
        //report from the list of reports
        //A single execution report may include multiple test reports
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Vystar Demo", "1"))
                .withJob(new Job("Vystar", 1))
                .withContextTags("IOS", "Penn", "Credit Union", "Regression", "Smoke")
                .withWebDriver(driver)
                .build();
        //The ReportiumClient monitors the application and transfers the report information and artifacts to the Reporting storage server
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);

            Thread.sleep(5000);
            reportiumClient.testStart("Vystar Login Test", new TestContext("\"Vystar\", \"Smoke\", \"Penn\""));//notify reportiumClient that the test is starting
        try {
            Thread.sleep(500);

            // Enter the login credentials
            reportiumClient.stepStart("Enter the login credentials");///define the logical step of the test that includes one or more actual command steps in the automation script but delineate a logical sequence of command steps
            Thread.sleep(1000);
            driver.findElementByXPath("//*[@name=\"login_textfield\"]").sendKeys("penn@stephenpenn.com");
            Thread.sleep(1000);
            driver.findElementByXPath("//*[@name=\"passw_textfield\"]").sendKeys("Password123!");
            Thread.sleep(1000);
            reportiumClient.stepEnd();

            // Click the Login button
            reportiumClient.stepStart("Click the login button");
            driver.findElementByXPath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]").click();
            Thread.sleep(1000);
            driver.findElementByXPath("//*[@name=\"Login\"]").click();
            Thread.sleep(1000);
            reportiumClient.stepEnd();

            // Check if an error message is displayed

            By errorMessageLocator = new By.ByXPath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]");

            if(driver.findElement(errorMessageLocator).isDisplayed()) {

                String errorMessage = driver.findElement(errorMessageLocator).getText();  //"We can't find that username or password. You can reset your password or try again."

                //Report failure to reportium client and fail the test
                reportiumClient.testStop(TestResultFactory.createFailure(errorMessage, new Exception(errorMessage)));
               // Assert.fail(errorMessage);
                System.out.println("This is the error message " + errorMessage);
            } else {
                // Report success to reportium client
                reportiumClient.testStop(TestResultFactory.createSuccess());

            }
        } catch (Exception ex) {
            // Report failure to reportium client and fail the test
            reportiumClient.testStop(TestResultFactory.createFailure(ex.getMessage(), ex));//stop the test by notifying the reporting client that the test unit has completed and provide a status for the test completion
            ex.printStackTrace();
           // Assert.fail("Exception thrown: " + ex.getMessage());

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

