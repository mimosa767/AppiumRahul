package PageObject;

import io.appium.java_client.AppiumCommandInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage (AppiumDriver driver) {
      PageFactory.initElements(new AppiumFieldDecorator(driver), this);//initialize all the elements below with driver, since we're working with Appium we must add the AppiumFieldDectorator method

    }
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
    public WebElement Preferences;
}
