package browser_actions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions refresh() {
        driver.navigate().refresh();
        return this;
    }

    public BrowserActions openUrl(String url) {
        driver.navigate().to(url);
        return this;
    }

    public BrowserActions back() {
        driver.navigate().back();
        return this;
    }

    public BrowserActions forward() {
        driver.navigate().forward();
        return this;
    }

    public BrowserActions setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        return this;
    }

    public BrowserActions deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
        return this;
    }

}
