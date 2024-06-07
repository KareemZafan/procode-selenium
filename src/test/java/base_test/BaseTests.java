package base_test;

import browser_actions.DriverFactory;
import element_actions.Element;
import io.PropertiesFileManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.SignUp;

public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;
    protected Element elementActions;
    protected PropertiesFileManager prop;

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        elementActions = new Element(driver);
        prop = new PropertiesFileManager("src/test/resources/testData/users.properties");

    }

    @BeforeMethod
    public void openUrl(){
      homePage.open();
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
