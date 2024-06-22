package base_test;

import browser_actions.BrowserActions;
import browser_actions.DriverFactory;
import com.opencsv.exceptions.CsvValidationException;
import element_actions.Element;
import io.CSVFileManager;
import io.PropertiesFileManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUp;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTests {

    public static Logger log = LogManager.getLogger();
    protected static DriverFactory driverFactory = new DriverFactory();
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected Element elementActions;
    protected BrowserActions browserActions;
    protected SignUp signUp;
    protected PropertiesFileManager prop;
    protected List<String[]> csvFileData;
    private CSVFileManager csvData;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        driverFactory.setRemoteDriver(browser);
        driverFactory.getDriver().manage().window().maximize();
        homePage = new HomePage(driverFactory.getDriver());
        loginPage = new LoginPage(driverFactory.getDriver());
        elementActions = new Element(driverFactory.getDriver());
        browserActions = new BrowserActions(driverFactory.getDriver());
        signUp = new SignUp(driverFactory.getDriver());

        prop = new PropertiesFileManager("src/test/resources/testData/users.properties");
        try {
            csvData = new CSVFileManager("src/test/resources/testData/users.csv", 1);
            csvFileData = csvData.readCSVFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

    }

    @BeforeMethod
    public void openUrl() {
        homePage.open();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File srcFile = ((TakesScreenshot) driverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
                log.info("Can't take screenshot.");
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driverFactory.getDriver().quit();
    }
}
