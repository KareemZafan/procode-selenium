package listeners;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SeleniumListeners implements WebDriverListener {
    public void beforeAnyCall(Object target, Method method, Object[] args) {
    }

    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
    }

    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
    }

    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
    }

    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
    }

    public void beforeGet(WebDriver driver, String url) {
    }

    public void afterGet(WebDriver driver, String url) {
    }

    public void beforeGetCurrentUrl(WebDriver driver) {
    }

    public void afterGetCurrentUrl(WebDriver driver, String result) {
    }

    public void beforeGetTitle(WebDriver driver) {
    }

    public void afterGetTitle(WebDriver driver, String result) {
    }

    public void beforeFindElement(WebDriver driver, By locator) {
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    }

    public void beforeFindElements(WebDriver driver, By locator) {
    }

    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
    }

    public void beforeGetPageSource(WebDriver driver) {
    }

    public void afterGetPageSource(WebDriver driver, String result) {
    }

    public void beforeClose(WebDriver driver) {
    }

    public void afterClose(WebDriver driver) {
    }

    public void beforeQuit(WebDriver driver) {
        System.out.println("closing Driver");

    }

    public void afterQuit(WebDriver driver) {
    }

    public void beforeGetWindowHandles(WebDriver driver) {
    }

    public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
    }

    public void beforeGetWindowHandle(WebDriver driver) {
    }

    public void afterGetWindowHandle(WebDriver driver, String result) {
    }

    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
    }

    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
    }

    public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {
    }

    public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {
    }

    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
    }

    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
    }

    public void beforeResetInputState(WebDriver driver) {
    }

    public void afterResetInputState(WebDriver driver) {
    }

    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
    }

    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
    }

    public void beforeClick(WebElement element) {
    }

    public void afterClick(WebElement element) {
    }

    public void beforeSubmit(WebElement element) {
    }

    public void afterSubmit(WebElement element) {
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {

    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    }

    public void beforeClear(WebElement element) {
    }

    public void afterClear(WebElement element) {
    }

    public void beforeGetTagName(WebElement element) {
    }

    public void afterGetTagName(WebElement element, String result) {
    }

    public void beforeGetAttribute(WebElement element, String name) {
    }

    public void afterGetAttribute(WebElement element, String name, String result) {
    }

    public void beforeIsSelected(WebElement element) {
    }

    public void afterIsSelected(WebElement element, boolean result) {
    }

    public void beforeIsEnabled(WebElement element) {
    }

    public void afterIsEnabled(WebElement element, boolean result) {
    }

    public void beforeGetText(WebElement element) {
    }

    public void afterGetText(WebElement element, String result) {
        System.out.println("Element is existing, then get its text !");
    }

    public void beforeFindElement(WebElement element, By locator) {
    }

    public void afterFindElement(WebElement element, By locator, WebElement result) {
    }

    public void beforeFindElements(WebElement element, By locator) {
    }

    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
    }

    public void beforeIsDisplayed(WebElement element) {
    }

    public void afterIsDisplayed(WebElement element, boolean result) {
    }

    public void beforeGetLocation(WebElement element) {
    }

    public void afterGetLocation(WebElement element, Point result) {
    }

    public void beforeGetSize(WebElement element) {
    }

    public void afterGetSize(WebElement element, Dimension result) {
    }

    public void beforeGetCssValue(WebElement element, String propertyName) {
    }

    public void afterGetCssValue(WebElement element, String propertyName, String result) {
    }

    public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args) {
    }

    public void afterAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args, Object result) {
    }

    public void beforeTo(WebDriver.Navigation navigation, String url) {
    }

    public void afterTo(WebDriver.Navigation navigation, String url) {
    }

    public void beforeTo(WebDriver.Navigation navigation, URL url) {
    }

    public void afterTo(WebDriver.Navigation navigation, URL url) {
    }

    public void beforeBack(WebDriver.Navigation navigation) {
    }

    public void afterBack(WebDriver.Navigation navigation) {
    }

    public void beforeForward(WebDriver.Navigation navigation) {
    }

    public void afterForward(WebDriver.Navigation navigation) {
    }

    public void beforeRefresh(WebDriver.Navigation navigation) {
    }

    public void afterRefresh(WebDriver.Navigation navigation) {
    }

    public void beforeAnyAlertCall(Alert alert, Method method, Object[] args) {
    }

    public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result) {
    }

    public void beforeAccept(Alert alert) {
    }

    public void afterAccept(Alert alert) {
    }

    public void beforeDismiss(Alert alert) {
    }

    public void afterDismiss(Alert alert) {
    }

    public void beforeGetText(Alert alert) {
    }

    public void afterGetText(Alert alert, String result) {
    }

    public void beforeSendKeys(Alert alert, String text) {
        System.out.println("Typing "+text);
    }

    public void afterSendKeys(Alert alert, String text) {
    }

    public void beforeAnyOptionsCall(WebDriver.Options options, Method method, Object[] args) {
    }

    public void afterAnyOptionsCall(WebDriver.Options options, Method method, Object[] args, Object result) {
    }

    public void beforeAddCookie(WebDriver.Options options, Cookie cookie) {
    }

    public void afterAddCookie(WebDriver.Options options, Cookie cookie) {
    }

    public void beforeDeleteCookieNamed(WebDriver.Options options, String name) {
    }

    public void afterDeleteCookieNamed(WebDriver.Options options, String name) {
    }

    public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {
    }

    public void afterDeleteCookie(WebDriver.Options options, Cookie cookie) {
    }

    public void beforeDeleteAllCookies(WebDriver.Options options) {
    }

    public void afterDeleteAllCookies(WebDriver.Options options) {
    }

    public void beforeGetCookies(WebDriver.Options options) {
    }

    public void afterGetCookies(WebDriver.Options options, Set<Cookie> result) {
    }

    public void beforeGetCookieNamed(WebDriver.Options options, String name) {
    }

    public void afterGetCookieNamed(WebDriver.Options options, String name, Cookie result) {
    }

    public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args) {
    }

    public void afterAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args, Object result) {
    }

    public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
    }

    public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
    }

    public void beforeSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {
    }

    public void afterSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {
    }

    public void beforePageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {
    }

    public void afterPageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {
    }

    public void beforeAnyWindowCall(WebDriver.Window window, Method method, Object[] args) {
    }

    public void afterAnyWindowCall(WebDriver.Window window, Method method, Object[] args, Object result) {
    }

    public void beforeGetSize(WebDriver.Window window) {
    }

    public void afterGetSize(WebDriver.Window window, Dimension result) {
    }

    public void beforeSetSize(WebDriver.Window window, Dimension size) {
    }

    public void afterSetSize(WebDriver.Window window, Dimension size) {
    }

    public void beforeGetPosition(WebDriver.Window window) {
    }

    public void afterGetPosition(WebDriver.Window window, Point result) {
    }

    public void beforeSetPosition(WebDriver.Window window, Point position) {
    }

    public void afterSetPosition(WebDriver.Window window, Point position) {
    }

    public void beforeMaximize(WebDriver.Window window) {
        System.out.println("Maximizing browser window");
    }

    public void afterMaximize(WebDriver.Window window) {
    }

    public void beforeFullscreen(WebDriver.Window window) {
    }

    public void afterFullscreen(WebDriver.Window window) {
    }

    public void beforeAnyTargetLocatorCall(WebDriver.TargetLocator targetLocator, Method method, Object[] args) {
    }

    public void afterAnyTargetLocatorCall(WebDriver.TargetLocator targetLocator, Method method, Object[] args, Object result) {
    }

    public void beforeFrame(WebDriver.TargetLocator targetLocator, int index) {
    }

    public void afterFrame(WebDriver.TargetLocator targetLocator, int index, WebDriver driver) {
    }

    public void beforeFrame(WebDriver.TargetLocator targetLocator, String nameOrId) {
    }

    public void afterFrame(WebDriver.TargetLocator targetLocator, String nameOrId, WebDriver driver) {
    }

    public void beforeFrame(WebDriver.TargetLocator targetLocator, WebElement frameElement) {
    }

    public void afterFrame(WebDriver.TargetLocator targetLocator, WebElement frameElement, WebDriver driver) {
    }

    public void beforeParentFrame(WebDriver.TargetLocator targetLocator) {
    }

    public void afterParentFrame(WebDriver.TargetLocator targetLocator, WebDriver driver) {
    }

    public void beforeWindow(WebDriver.TargetLocator targetLocator, String nameOrHandle) {
    }

    public void afterWindow(WebDriver.TargetLocator targetLocator, String nameOrHandle, WebDriver driver) {
    }

    public void beforeNewWindow(WebDriver.TargetLocator targetLocator, WindowType typeHint) {
    }

    public void afterNewWindow(WebDriver.TargetLocator targetLocator, WindowType typeHint, WebDriver driver) {
    }

    public void beforepublicContent(WebDriver.TargetLocator targetLocator) {
    }

    public void afterpublicContent(WebDriver.TargetLocator targetLocator, WebDriver driver) {
    }

    public void beforeActiveElement(WebDriver.TargetLocator targetLocator) {
    }

    public void afterActiveElement(WebDriver.TargetLocator targetLocator, WebDriver driver) {
    }

    public void beforeAlert(WebDriver.TargetLocator targetLocator) {
    }

    public void afterAlert(WebDriver.TargetLocator targetLocator, Alert alert) {
    }
}
