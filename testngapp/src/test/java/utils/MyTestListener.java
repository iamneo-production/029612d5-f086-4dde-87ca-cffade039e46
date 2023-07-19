package utils;

import com.aventstack.extentreports.Status;

import org.testng.ITestListener;
import org.testng.ITestResult;

import ObjectClasses.SetupDriver;

public class MyTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        SetupDriver.test = SetupDriver.extent.createTest(methodName);
    } 

    @Override
    public void onTestSuccess(ITestResult result) {
        SetupDriver.test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        SetupDriver.test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
    }

}
