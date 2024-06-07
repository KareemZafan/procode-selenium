package pages;

import io.PropertiesFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePage {
    private WebDriver driver;
    PropertiesFileManager props;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        props = new PropertiesFileManager("src/test/resources/testData/users.properties");
    }

    public void open() {
        driver.get(props.getProperty("url"));
    }

    public void navigateTo(String title){
        driver.findElement(By.partialLinkText(title)).click();
    }
}
