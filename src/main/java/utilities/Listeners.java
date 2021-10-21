package utilities;
// for using 'Listener' we need to use and implement TestNg interface 'listeners'

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import runers.Base;

import java.io.IOException;

import static runers.Base.getScreenshot;

public class Listeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        String testName = result.getName();
        System.out.println(">>>>>> Listeners -onTestFailure: FAILED test name is: " + testName);
        //screenshot
        try {
            getScreenshot(testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println(">>>>>> Listeners - onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println(">>>>>> Listeners - onFinish");
    }
}
