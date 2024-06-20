package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Execution Started (^_^)");
        //log file
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() +"is Passed " + "Don't need to take screenshot");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() +"is Failed" + "Take screenshot");
    }

    public void  onTestSkipped(ITestResult result) {
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
