package TestNGProject;

import org.testng.annotations.*;


public class day3 {
    @Parameters({"URL"})
    @Test
    public void WebLoginLoan (String urlName) {
        System.out.println("This is the Weblogin in the Day3 class; and the UrlName is " + urlName);
    }
    @BeforeClass
    public void BeforeLoginLoan () {
        System.out.println("This is the BeforeClass in the Day3 class");
    }
    @AfterClass
    public void AfterLoginLoan () {
        System.out.println("This is the AfterClass in the Day3 class");
    }
    @BeforeSuite
    public void BFSuite () {
        System.out.println("This is the BFSuite in the Day3 class");
    }
    @AfterSuite
    public void AFSuite () {
        System.out.println("This is the AFSuite in the Day3 class");
    }
    @Parameters({"URL"})
    @Test(groups = {"Smoke"})
    public void MobileLoginLoan (String urlName) {
        System.out.println("This is the MobileLogin in the Day3 class; the parameter being passed is " + urlName);
    }
    @BeforeMethod
    public void BeforeMobileLoginLoan () {
        System.out.println("This is the BeforeMethodMobileLogin in the Day3 class");
    }
    @AfterMethod
    public void AfterMobileLoginLoan () {
        System.out.println("This is the AfterMethodMobileLogin in the Day3 class");
    }


    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void LoginAPICarLoan (String username, String password) {
        System.out.println("This is the LoginAPICarLoan in the Day3 class");
        System.out.println("The Username and Password are " + username + " " + password);
    }
    @AfterTest
    public void AfterTest () {
        System.out.println("This is the AfterTest in the Day3 class");
    }
    @BeforeTest
    public void BeforeTest () {
        System.out.println("This is the BeforeTest in the Day3 class");
    }
    @DataProvider
    public Object[][] getData() {
        //1st combination - username, password, good credit history
        //2nd combination - username, password,no credit history
        //create multidimensional array with 3 rows and two columns
        Object [][] data = new Object[3][2];
        //1st set
        data[0][0] = "firstusername";
        data[0][1] = "passwordforfirst";
        //2nd set
        data[1][0] = "secondusername";
        data[1][1] = "passwordforsecond";
        //3rd set
        data[2][0] = "thirdusername";
        data[2][1] = "thirdpassword";
        return data;
    }
}