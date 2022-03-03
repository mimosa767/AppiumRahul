package TestNGProject;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class day1  {

    @Parameters({"URL", "APIKey/username"})
    @Test
    public void Demo (String urlName, String apiKey) {
        System.out.println("This is Demo in the Day1 class; and the parameter being passed is " + urlName + "This is my second parameter" + apiKey );
        Assert.assertTrue(false);
    }

    @Parameters({"URL"})
    @Test
    public void Demo1 (String urlName) {
        System.out.println("This is the Demo1 in the Day1 class; and the parameter being passed is " + urlName);
    }

}