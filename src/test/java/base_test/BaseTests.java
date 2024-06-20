package base_test;

import browser_actions.BrowserActions;
import browser_actions.DriverFactory;
import com.opencsv.exceptions.CsvValidationException;
import element_actions.Element;
import io.CSVFileManager;
import io.PropertiesFileManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUp;

import java.io.IOException;
import java.util.List;

public class BaseTests {

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
    public void setUp() {
        driverFactory.setDriver(DriverFactory.BrowserType.CHROME);
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


    @AfterTest
    public void tearDown() {
        driverFactory.getDriver().quit();
    }
}
