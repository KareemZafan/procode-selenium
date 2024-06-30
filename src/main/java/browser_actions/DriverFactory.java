package browser_actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

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

    public void setRemoteDriver(String browserName) {
        List<String> arguments = List.of("--disable-notifications", "--disable-popup-blocking", "--incognito");
        //todo configure options for multiple different browsers
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                //options.addArguments(arguments);
                options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "dismiss");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setAcceptInsecureCerts(true);
                caps.setBrowserName(browserName);
                options.merge(caps);
                try {
                    drivers.set(new RemoteWebDriver(new URL("http://localhost:4444  "), options));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "firefox":
                FirefoxOptions options1 = new FirefoxOptions();
                options1.addArguments(arguments);
                options1.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "dismiss");
                DesiredCapabilities caps1 = new DesiredCapabilities();
                caps1.setAcceptInsecureCerts(true);
                caps1.setBrowserName(browserName);
                options1.merge(caps1);
                try {
                    drivers.set(new RemoteWebDriver(new URL("http://localhost:4444"), options1));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "edge":
                EdgeOptions options2 = new EdgeOptions();
                options2.addArguments(arguments);
                options2.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "dismiss");
                DesiredCapabilities caps2 = new DesiredCapabilities();
                caps2.setAcceptInsecureCerts(true);
                caps2.setBrowserName(browserName);
                options2.merge(caps2);
                try {
                    drivers.set(new RemoteWebDriver(new URL("http://localhost:4444"), options2));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported Browser!");
        }
    }

    public ThreadLocal<WebDriver> getDrivers() {
        return drivers;
    }

    public enum BrowserType {
        CHROME, FIREFOX, EDGE

        //todo add more drivers such a safari, opera ...
    }

}
