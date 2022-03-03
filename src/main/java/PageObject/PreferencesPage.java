package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PreferencesPage {

    public PreferencesPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);//initialize all the elements below with driver, since we're working with Appium we must add the AppiumFieldDectorator method

    }
    @AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
    public WebElement preferenceDependencies;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> lastClassButton; //this handles findElements plural, so we need to use the List class and import

}
