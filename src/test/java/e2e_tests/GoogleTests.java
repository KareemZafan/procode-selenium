package e2e_tests;

import browser_actions.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoogleTests {

    private WebDriver driver;


    @BeforeTest
    void setUp() {
        driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    void openUrl() {
        driver.get("https://www.google.com/");
    }

    @Test
    void testGoogleLogo() {
        assertTrue(driver.findElement(By.cssSelector("img.lnXdpd")).isDisplayed());
    }

    @Test
    void testSearchResults() {
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        String text = driver.findElement(By.cssSelector("div.g a h3 span:nth-child(1)")).getText();
        assertEquals(text, "Selenium");
    }


    @Test(description = "Featuer-123 Test Title", testName = "Test 1", priority = 4)
    void testGoogleTitle() {
        assertEquals(driver.getTitle(), "Google");
    }


    @AfterTest
    void closeSession() {
        driver.quit();
    }
}
