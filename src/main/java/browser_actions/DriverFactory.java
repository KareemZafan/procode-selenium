package browser_actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.List;

public class DriverFactory {
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public WebDriver getDriver() {
        return drivers.get();
    }

    public void setDriver(BrowserType browserType) {
        List<String> arguments = List.of("--disable-notifications", "--disable-popup-blocking", "--incognito");
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(arguments);
                chromeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "dismiss");
                drivers.set(new ChromeDriver(chromeOptions));
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(arguments);
                firefoxOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "dismiss");
                drivers.set(new FirefoxDriver(firefoxOptions));
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(arguments);
                edgeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "dismiss");
                drivers.set(new EdgeDriver(edgeOptions));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }

    public ThreadLocal<WebDriver> getDrivers() {
        return drivers;
    }

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE

        //todo add more drivers safari opera
    }

}
