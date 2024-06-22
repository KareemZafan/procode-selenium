package e2e_tests;

import base_test.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoogleTests extends BaseTests {

    private WebDriver driver;


    @BeforeClass
    void setUpClassTests() {
        driver = driverFactory.getDriver();
    }

    @BeforeMethod
    public void openUrl() {
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

}
