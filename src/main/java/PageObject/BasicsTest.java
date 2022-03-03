package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicsTest {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("app", "/Users/spenn02/appiumjava/untitled/application/ApiDemos-debug.apk");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        PreferencesPage preferences = new PreferencesPage(driver);
        DependenciesPage dependencies = new DependenciesPage(driver);
        homePage.Preferences.click();
        preferences.preferenceDependencies.click();
        dependencies.wifiCheckbox.click();
        dependencies.wifiSettingsLink.click();
        dependencies.wifiSettingsTextBox.sendKeys("YouDaMan");
        preferences.lastClassButton.get(1).click();
        driver.quit();




    }
}
