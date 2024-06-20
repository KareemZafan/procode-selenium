package automation_exercise;

import base_test.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @BeforeMethod
    void setUpMethod() {
        homePage.navigateTo("Signup / Login");
    }

    @Test
    void checkLoginFunctionality() {
        String[] line = csvFileData.get(2);
        assertEquals(loginPage.login(line[1], line[2] + "r").getLoggedInUser(), "Farse");
    }

}
