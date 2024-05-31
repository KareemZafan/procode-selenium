package automation_exercise;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class HomePageTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    void setUpMethod() {
        homePage.open();
    }


    @Test
    void testAdvertisementIsVisible(){
      homePage.navigateTo("Products");
      assertTrue(driver.findElement(By.cssSelector("img#sale_image")).isDisplayed());

    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
