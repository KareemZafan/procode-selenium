package e2e_tests;

import base_test.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginWithCookiesTests extends BaseTests {
    private WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = driverFactory.getDriver();
    }

    @BeforeMethod
    public void openUrl() {
        browserActions.openUrl("https://testpages.eviltester.com/styled/cookies/adminlogin.html");
    }

    @Test
    void testLoginAsAdminByInsertingCookie() {
        Cookie cookie = new Cookie("loggedin", "Admin");
        browserActions.setCookie(cookie).refresh();

        assertEquals(elementActions.getElementText(By.id("adminh1")), "Admin View");
        browserActions.deleteCookie(cookie).refresh();

    }

    @Test
    void testLoginAsSuperAdminByInsertingCookie() {
        Cookie cookie = new Cookie("loggedin", "SuperAdmin");
        browserActions.setCookie(cookie).refresh();

        assertEquals(elementActions.getElementText(By.id("superadminh1")), "Super Admin View");
        browserActions.deleteCookie(cookie).refresh();

    }

    @Test
    void checkAccessingInsecureWebsites() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setAcceptInsecureCerts(true);
        ChromeOptions chromeOptions = new ChromeOptions().merge(dc);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://expired.badssl.com/");
        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("expired"));
    }

}
