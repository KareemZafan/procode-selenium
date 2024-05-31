package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp_Login_Page {
    private WebDriver driver;

    public SignUp_Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String name, String email){
     driver.findElement(By.cssSelector("div.signup-form input[name='name']")).sendKeys(name);
     driver.findElement(By.cssSelector("div.signup-form input[name='email']")).sendKeys(email);
     driver.findElement(By.cssSelector("div.signup-form button")).click();
    }

    public void login(String email, String password) {
        driver.findElement(By.cssSelector("div.login-form input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("div.login-form input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("div.login-form button")).click();
    }


}
