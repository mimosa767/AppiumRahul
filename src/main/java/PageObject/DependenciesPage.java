package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DependenciesPage {

    public DependenciesPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);//initialize all the elements below with driver, since we're working with Appium we must add the AppiumFieldDectorator method

    }
    @AndroidFindBy(id="android:id/checkbox")
    public WebElement wifiCheckbox;

    @AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
    public WebElement wifiSettingsLink;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement wifiSettingsTextBox;




}
