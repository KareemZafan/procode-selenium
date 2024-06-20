package e2e_tests;

import base_test.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    private WebDriver driver;

    @BeforeTest
    void setUpClassTests() {
        driver = driverFactory.getDriver();
    }

    @BeforeMethod
    public void openUrl() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    void testLoginHappyScenario() {
        //Actions
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!", Keys.ENTER);
        // driver.findElement(By.cssSelector("button.radius")).click();

        //Assertions

        String loginText = driver.findElement(By.id("flash-messages")).getText();

        assertTrue(loginText.contains("You logged into a secure area!"));
    }

}
