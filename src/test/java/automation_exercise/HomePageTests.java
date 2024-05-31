package automation_exercise;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    void setUpMethod() {
        homePage.open();
    }


    @Test
    void testAdvertisementIsVisible() {
      homePage.navigateTo("Products");
      assertTrue(driver.findElement(By.cssSelector("img#sale_image")).isDisplayed());
    }

    @Test
    void testCartIsEmpty() {
        homePage.navigateTo("Cart");
        assertTrue(driver.findElement(By.id("empty_cart")).getText().contains("Cart is empty!"));
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
