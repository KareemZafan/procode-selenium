package pages;

import element_actions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private Element elementActions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementActions = new Element(driver);
    }

    public LoginPage login(String email, String password) {
        elementActions
                .type(By.cssSelector("div.login-form input[name='email']"), email)
                .type(By.cssSelector("div.login-form input[name='password']"), password)
                .click(By.cssSelector("div.login-form button"));
        return this;
    }

    public String getLoggedInUser() {
        return elementActions.getElementText(By.cssSelector("a > b"));
    }

    public void logout() {
        elementActions.click(By.partialLinkText("logout"));
    }

    public void deleteAccount() {
        elementActions.click(By.partialLinkText("Delete Account"));
    }

}
