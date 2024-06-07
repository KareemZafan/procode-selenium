package automation_exercise;

import com.opencsv.exceptions.CsvValidationException;
import element_actions.Element;
import io.CSVFileManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoginTests {

    private WebDriver driver;
    private HomePage homePage;
    private Login login;
    private Element elementActions;
    private CSVFileManager csvData;
    private List<String[]> csvFileData;
    private String[] line;

    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        elementActions = new Element(driver);
        login = new Login(driver);
        try {
            csvData = new CSVFileManager("src/test/resources/testData/users.csv", 1);
            csvFileData = csvData.readCSVFile();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeMethod
    void setUpMethod() {
        homePage.open();
        homePage.navigateTo("Signup / Login");
    }

    @Test
    void checkLoginFunctionality() {
        line = csvFileData.get(2);
        assertEquals(login.login(line[1], line[2]).getLoggedInUser(), "Farse");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
