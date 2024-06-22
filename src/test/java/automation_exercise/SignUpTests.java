package automation_exercise;

import base_test.BaseTests;
import listeners.RetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUp;

import static org.testng.Assert.assertTrue;

public class SignUpTests extends BaseTests {

    @BeforeMethod
    void setUpMethod() {
        homePage.open();
        homePage.navigateTo("Signup / Login");
    }

    @Test(retryAnalyzer=RetryAnalyzer.class)
    void testRegistration() {
        //Arrange
        String[] thirdLine = csvFileData.get(3);
        log.info("Signing Up for user: {}, email: {}", thirdLine[0], thirdLine[1]);
        signUp.register(thirdLine[0], thirdLine[1]);


        //Actions
        log.info("Selecting gender: Mr");
        signUp.enterTitle(SignUp.Gender.MALE);
        signUp.enterName("Kareem");
        signUp.enterPassword("UserPass123405#");
        signUp.selectDay("1");
        signUp.selectMonth("March");
        signUp.selectYear("2000");
        signUp.selectOptionWithText("Sign up for our newsletter!");
        signUp.selectOptionWithText("Receive special offers from our partners!");

        log.info("username is: Kareem");
        signUp.enterFirstName("Kareem");
        signUp.enterLastName("Mohamed");
        signUp.enterCompany("X-Compny");
        signUp.enterAddress1("19 Ahmed Orabay Shubra");
        signUp.selectCountry("Singapore");
        signUp.enterState("Egypt");
        signUp.enterCity("Cairo");
        signUp.enterZipCode("11111");
        signUp.enterMobileNumber("01020202020");
        log.warn("Account might not be created");
        signUp.clickCreateAccount();

        //Assertions
        assertTrue(signUp.isAccountCreated(), "Account Was Not Created");

        // Deleting Account
        homePage.navigateTo("Signup / Login");
        loginPage.deleteAccount();
    }

}
