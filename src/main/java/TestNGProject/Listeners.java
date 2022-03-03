package TestNGProject;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface that implements TestNG listeners
    public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I've successfully executed Listeners Pass Code");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //Screenshot code
        //response if API is failed
        System.out.println("This is my Listener for when their is a Failed Test; the test that was failed is " + iTestResult.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}



