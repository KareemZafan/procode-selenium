package e2e_tests;

import base_test.Base2Tests;
import base_test.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Google2Tests extends Base2Tests {

    private WebDriver driver;
    private EventFiringDecorator<WebDriver> eDriver;


    @BeforeClass
    void setUpClassTests() {
        driver = driverFactory.getDriver();
        eDriver = (EventFiringDecorator<WebDriver>) new EventFiringDecorator().decorate(driver);
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
