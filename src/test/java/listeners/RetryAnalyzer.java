package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final int Max = 4;
    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count < Max){
            ++count;
            return true;
        }
        return false;
    }
}

