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
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Objects;

public class Ecommerce_TestCase_1b_PerfectoReportiumEx extends LocalPerfectoDriverMethodEcommerce {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = LocalPerfectoDriverMethodEcommerce.capabilities();
        Thread.sleep(1000);
        //create a PerfectoExecutionContext instance
        //The execution context defines metadata for the Execution report. The metadata includes "tags" that can be used to select the exection
        //report from the list of reports
        //A single Execution report may include multiple test reports
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Ecommerce Purchase Scenario", "1"))
                        .withJob( new Job("Purchase Sneaker Checkout Flow", 1))
                                .withContextTags("Android", "Penn", "Ecommerce", "Regression", "Smoke")
                                        .withWebDriver(driver)
                                                .build();
        //The ReportiumClient monitors the application and transfers the report information and artifacts to the Reporting storage server
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
        try {
            Thread.sleep(500);
            reportiumClient.testStart("Fill in initial details for home screen", new TestContext("\"Sanity\", \"Smoke\""));//notify reportiumClient that the test is starting
            reportiumClient.stepStart("App is launched and the first steps begins");///define the logical step of the test that includes one or more actual command steps in the automation script but delineate a logical sequence of command steps
            driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Stephen is here");
            Thread.sleep(500);
            driver.hideKeyboard();
            Thread.sleep(500);
            driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
            Thread.sleep(500);
            driver.findElementById("android:id/text1").click();
            Thread.sleep(1000);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
            driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
            driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
            reportiumClient.stepEnd("Finished first screen");

            reportiumClient.stepStart("Scroll through sneakers, and put into cart");
            Thread.sleep(1000);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
            System.out.println("the size is " + driver.findElementsById("com.androidsample.generalstore:id/productName").size());
            Thread.sleep(1000);
            Thread.sleep(500);
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

            Thread.sleep(500);
            reportiumClient.stepStart("Begin the add to cart");
            driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
            Thread.sleep(500);
            String lastPageText = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
            Thread.sleep(500);
            System.out.println("This is the lastPageText " + lastPageText);
            Assert.assertEquals("Jordan 6 Rings", lastPageText);
            reportiumClient.reportiumAssert("The correct shoe was piced", true);
            reportiumClient.stepEnd();
            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception ex) {
            reportiumClient.testStop(TestResultFactory.createFailure(ex.getMessage(), ex));//stop the test by notifying the reporting client that the test unit has completed and provide a status for the test completion
            ex.printStackTrace();
        }
        Thread.sleep(500);
        driver.quit();
        String reportURL = reportiumClient.getReportUrl();//the reporting client can supply the URL to the report for retrieval, the report takes time because the different components needs to be compiled
        System.out.println(reportURL);

    }
}
