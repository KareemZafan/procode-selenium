package automation_exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUp_Login_Page;

import static org.testng.Assert.assertEquals;

public class SignUpLoginTests {

    private WebDriver driver;
    private HomePage homePage;
    private SignUp_Login_Page signUpLoginPage;

    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUp_Login_Page(driver);

    }

    @BeforeMethod
    void setUpMethod() {
        homePage.open();
        homePage.navigateTo("Signup / Login");
    }

    @Test
    void testRegistration() {
        //Actions
        signUpLoginPage.register("Kareem Mohamed", "test2@testTTTETst.com");


        //Assertion
        String headerText = driver.findElement(By.cssSelector("div.login-form > h2 > b")).getText();
        assertEquals(headerText, "ENTER ACCOUNT INFORMATION");

    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
