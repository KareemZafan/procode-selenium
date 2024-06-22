package e2e_tests;

import base_test.BaseTests;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @BeforeMethod
    public void openUrl() {
        browserActions.openUrl("https://the-internet.herokuapp.com/login");
    }

    @Test
    @Issue("Login-123")
    @Description("Login with valid credentials")
    @Feature("Login Fearure-123")
    @Severity(SeverityLevel.CRITICAL)
    void testLoginHappyScenario() {
        //Actions
        elementActions
                .type(By.id("username"), "tomsmith")
                .type(By.id("password"), "SuperSecretPassword!")
                .click(By.cssSelector("button.radius"));

        //Assertions
        assertTrue(elementActions.getElementText(By.id("flash-messages")).contains("You logged into a secure area!"));
    }

}
