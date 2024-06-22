package listeners;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(MyListener.class);

    public void onTestStart(ITestResult result) {
        System.out.println("Execution Started (^_^)");
        //log file
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + "is Passed " + "Don't need to take screenshot");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + "is Failed" + "Take screenshot");
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }


}
