package pages;

import element_actions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private Element elementActions;

    public Login(WebDriver driver) {
        this.driver = driver;
        elementActions = new Element(driver);
    }

    public Login login(String email, String password) {
        driver.findElement(By.cssSelector("div.login-form input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("div.login-form input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("div.login-form button")).click();
        return this;
    }

    public String getLoggedInUser() {
        return elementActions.getElementText(By.cssSelector("a > b"));
    }

    public void logout(){
        elementActions.click(By.partialLinkText("logout"));
    }

    public void deleteAccount() {
        elementActions.click(By.partialLinkText("Delete Account"));
    }


}
