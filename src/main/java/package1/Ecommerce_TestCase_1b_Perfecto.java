package package1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Objects;

public class Ecommerce_TestCase_1b_Perfecto extends LocalPerfectoDriverMethodEcommerce {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = LocalPerfectoDriverMethodEcommerce.capabilities();
        Thread.sleep(1000);
        Thread.sleep(500);
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
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
        System.out.println("the size is "+driver.findElementsById("com.androidsample.generalstore:id/productName").size());
        Thread.sleep(1000);
        Thread.sleep(500);
        int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        System.out.println("This is the count " + count);
        for (int i = 0; i < count; i++) {
            System.out.println("i is "+i);
            String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            System.out.println("this is the text "+text);
            if (Objects.equals(text, "Jordan 6 Rings")) {
                System.out.println("working if");
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break; //no need to iterate once we find the link were looking for
            }

        }

        Thread.sleep(500);
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(500);
        String lastPageText =  driver.findElementById("com.androidsample.generalstore:id/productName").getText();
        Thread.sleep(500);
        System.out.println("This is the lastPageText "+lastPageText);
        Assert.assertEquals("Jordan 6 Rings", lastPageText);
        Thread.sleep(500);
        driver.quit();

    }
}
