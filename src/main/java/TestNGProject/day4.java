package TestNGProject;

import org.testng.annotations.Test;


public class day4 {

    @Test(timeOut = 4000)
    public void WebLoginHomeLoan () {
        System.out.println("This is the WebHomelogin in the Day4 class");
    }


    @Test(enabled = true)
    public void MobileLoginHomeLoan () {
        System.out.println("This is the MobileHomeLogin in the Day4 class");
    }
    @Test(dependsOnMethods = {"WebLoginHomeLoan", "MobileLoginHomeLoan"})
    public void LoginAPICarHomeLoan () {
        System.out.println("This is the LoginAPICarHomeLoan in the Day4 class");
    }
}