package e2e_tests;

import browser_actions.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests {
    private WebDriver driver;

    @BeforeTest
    void setUp() {
        driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    void testLoginHappyScenario(){

        // Arrange
        driver.get("https://the-internet.herokuapp.com/login");

        //Actions
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!", Keys.ENTER);
       // driver.findElement(By.cssSelector("button.radius")).click();

       //Assertions

       String loginText = driver.findElement(By.id("flash-messages")).getText();

       assertTrue(loginText.contains("You logged into a secure area!"));
    }


    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
