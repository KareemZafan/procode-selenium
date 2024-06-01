package automation_exercise;

import element_actions.Element;
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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTests {

    private WebDriver driver;
    private HomePage homePage;
    private SignUp signUp;
    private Element elementActions;

    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        signUp = new SignUp(driver);
        elementActions = new Element(driver);

    }

    @BeforeMethod
    void setUpMethod() {
        homePage.open();
        homePage.navigateTo("Signup / Login");
    }

    @Test
    void testRegistration() {
        //Actions
        signUp.register("Kareem Mohamed", "test2@testTTTETst.com");

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

        assertEquals(driver.findElement(By.id("name")).getAttribute("value"),"Farse");
        Select sl = new Select(driver.findElement(By.id("years")));
        assertEquals(sl.getFirstSelectedOption().getText(),"2000");

        signUp.selectOptionWithText("Sign up for our newsletter!");
        signUp.selectOptionWithText("Receive special offers from our partners!");


        assertTrue(elementActions.isSelected(By.id("newsletter")));
        assertTrue(elementActions.isSelected(By.id("optin")));


    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
