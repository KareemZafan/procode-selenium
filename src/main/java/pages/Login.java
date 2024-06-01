package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String email, String password) {
        driver.findElement(By.cssSelector("div.login-form input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("div.login-form input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("div.login-form button")).click();
    }


}
