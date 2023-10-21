package package1;


import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerfectoNativeSample {

	public static void main(String[] args) throws Exception {

		int exitCode = 0;

		DesiredCapabilities capabilities = new DesiredCapabilities("", "", Platform.ANY);

		// 1. Replace <<cloud name>> with your Perfecto cloud name (for example, 'demo' is the cloud name of demo.perfectomobile.com).
		String cloudName = "trial";

		// 2. Replace <<security token>> with your Perfecto security token.
		String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI2ZDM2NmJiNS01NDAyLTQ4MmMtYTVhOC1kODZhODk4MDYyZjIifQ.eyJpYXQiOjE2ODUxMjk3NDUsImp0aSI6IjQ2ZDYyMDA2LTBmM2ItNGFmNy04YTVkLTVhMjU3NTM3OTMxNyIsImlzcyI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6ImUyMGM2OWY2LWU5NmQtNDE1OS05YjM2LWI5NDI0YTkzYTM4ZiIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiZWNlYjg3YWUtNmFmNi00ZjlhLThjOTYtYjhiYjY5ZjFkNDBjIiwic2Vzc2lvbl9zdGF0ZSI6ImNhZGNiZGIxLWU4NzItNDQ2Yi04YTVmLTFlNDA3YTExOTU5MCIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwifQ.gC8lW__EwEcBGy57gF9cJT72vhi71X--vuvUp1CYPPg";

		capabilities.setCapability("securityToken", securityToken);

		// 3. Set the device capabilities.
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "14.2");
		capabilities.setCapability("manufacturer", "Apple");
		capabilities.setCapability("model", "iPhone-11 Pro");

		// 4. Set the Perfecto media repository path of the app under test.
		capabilities.setCapability("app", "PUBLIC:InvoiceApp1.0.ipa");

		// 5. Set the unique identifier of your app.
		capabilities.setCapability("bundleId", "io.perfecto.expense.tracker");

		// 6. Set other capabilities.
		capabilities.setCapability("enableAppiumBehavior", true); // Enable the new Appium Architecture.
		capabilities.setCapability("autoLaunch", true); // Whether to install and launch the app automatically.
		capabilities.setCapability("autoInstrument", true); // To work with hybrid applications, install the iOS/Android application as instrumented.
		capabilities.setCapability("takesScreenshot", true);
		capabilities.setCapability("screenshotOnError", true);
		// capabilities.setCapability("fullReset", false); // Reset the app state by uninstalling the app.

		// 7. Initialize the IOSDriver driver.

		Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
				new URL("https://" + cloudName + ".perfectomobile.com/nexperience/perfectomobile/wd/hub"),
				capabilities);

		// 8. Set an implicit wait.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		PerfectoExecutionContext perfectoExecutionContext;
		if (System.getenv("jobName") != null) {
			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
					.withProject(new Project("Sample Project", "1.0"))
					.withJob(new Job(System.getenv("jobName"),
							Integer.parseInt(System.getenv("jobNumber"))))
					.withWebDriver(driver).build();
		} else {
			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
					.withProject(new Project("Sample Project", "1.0"))
					.withWebDriver(driver)
					.build();
		}

		ReportiumClient reportiumClient = new ReportiumClientFactory()
				.createPerfectoReportiumClient(perfectoExecutionContext);

		reportiumClient.testStart("Native Java iOS Sample", new TestContext("native", "ios"));

		try {

		    /**
		    *****************************
		    *** Your test starts here. If you test a different app, you need to modify the test steps accordingly. ***
		    *****************************
		    */


			reportiumClient.stepStart("Enter email");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			IOSElement email = (IOSElement) wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login_email"))));
			email.sendKeys("test@perfecto.com");
			reportiumClient.stepEnd();

			reportiumClient.stepStart("Enter password");
			IOSElement password = (IOSElement) wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login_password"))));
			password.sendKeys("test123");
			driver.hideKeyboard();
			reportiumClient.stepEnd();


			reportiumClient.stepStart("Click login");
			IOSElement login = (IOSElement) wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login_login_btn"))));
			login.click();
			reportiumClient.stepEnd();

			reportiumClient.stepStart("Add expense");
			IOSElement add_expense = (IOSElement) wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("list_add_btn"))));
			add_expense.click();
			reportiumClient.stepEnd();


			reportiumClient.stepStart("Select head");
			IOSElement head = (IOSElement) wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("edit_head"))));
			head.click();
			List<WebElement> picker = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@value=\"- Select -\"]")));
			picker.get(0).sendKeys("Flight");
			reportiumClient.stepEnd();


			reportiumClient.stepStart("Enter amount");
			IOSElement amount = (IOSElement) new WebDriverWait(driver, 30)
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("edit_amount"))));
			amount.sendKeys("100");
			reportiumClient.stepEnd();

			reportiumClient.stepStart("Save expense");
			IOSElement save_expense = (IOSElement) new WebDriverWait(driver, 30)
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("add_save_btn"))));
			save_expense.click();
			reportiumClient.stepEnd();

		    /**
		    *****************************
		    *** Your test ends here. ***
		    *****************************
		    */

			reportiumClient.testStop(TestResultFactory.createSuccess());
		} catch (Exception e) {

			reportiumClient.testStop(TestResultFactory.createFailure(e));
			exitCode = 1;
		}

		// Obtains the Report URL
		String reportURL = reportiumClient.getReportUrl() + "&onboardingJourney=automated&onboardingDevice=nativeApp";

		// Quits the driver

		driver.quit();

		// Prints the Report URL

		System.out.println("\n\nOpen this link to continue with the guide: " + reportURL + "\n");

		// Launch browser with the Report URL
		try {
			Desktop.getDesktop().browse(new URI(reportURL));
		} catch (Exception e) {
			System.out.println("Unable to open Reporting URL in browser: " + e.getMessage());
		}

		System.exit(exitCode);
	}


	}

