package automation_exercise;

import com.opencsv.exceptions.CsvValidationException;
import element_actions.Element;
import io.CSVFileManager;
import io.JSONFileManager;
import io.PropertiesFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUp;

import java.io.IOException;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTests {

    private WebDriver driver;
    private HomePage homePage;
    private SignUp signUp;
    private Element elementActions;
    private JSONFileManager jsonFileManager;
    private CSVFileManager csvData;
    private PropertiesFileManager prop;

    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        signUp = new SignUp(driver);
        elementActions = new Element(driver);
        try {
            csvData = new CSVFileManager("src/test/resources/testData/users.csv", 1);
            prop = new PropertiesFileManager("src/test/resources/testData/users.properties");
            jsonFileManager = new JSONFileManager("src/test/resources/testData/users.json");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @BeforeMethod
    void setUpMethod() {
        homePage.open();
        homePage.navigateTo("Signup / Login");
    }

    @Test
    void testRegistration() throws IOException, CsvValidationException {
        //Actions
        homePage.navigateTo("Signup / Login");
        // signUp.register(jsonFileManager.getObject("$.users[0].username").toString(), jsonFileManager.getObject("$.users[0].email").toString());
        String[] thirdLine = csvData.readCSVFile().get(2);
        signUp.register(thirdLine[0], thirdLine[1]);


        //Assertion
        String headerText = elementActions.getElementText(By.cssSelector("div.login-form > h2 > b"));
        assertEquals(headerText, "ENTER ACCOUNT INFORMATION");

        signUp.enterTitle(SignUp.Gender.MALE);
        assertTrue(elementActions.isSelected(By.id("id_gender1")));
        signUp.enterTitle(SignUp.Gender.FEMALE);
        assertTrue(elementActions.isSelected(By.id("id_gender2")));

        signUp.enterName("Farse");
        signUp.enterPassword("UserPass123405#");
        signUp.selectDay("1");
        signUp.selectMonth("March");
        signUp.selectYear("2000");

        assertEquals(driver.findElement(By.id("name")).getAttribute("value"), "Farse");
        Select sl = new Select(driver.findElement(By.id("years")));
        assertEquals(sl.getFirstSelectedOption().getText(), "2000");

        signUp.selectOptionWithText("Sign up for our newsletter!");
        signUp.selectOptionWithText("Receive special offers from our partners!");


        assertTrue(elementActions.isSelected(By.id("newsletter")));
        assertTrue(elementActions.isSelected(By.id("optin")));

        signUp.enterFirstName("Fares");
        signUp.enterLastName("Farse");
        signUp.enterCompany("X-Compny");
        signUp.enterAddress1("19 Ahmed Orabay Shubra");
        signUp.selectCountry("Singapore");
        signUp.enterState("Egypt");
        signUp.enterCity("Cairo");
        signUp.enterZipCode("11111");
        signUp.enterMobileNumber("01020202020");
        signUp.clickCreateAccount();

        assertTrue(signUp.isAccountCreated(),"Account Was Not Created");
        //todo delete account for repeatability
    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
