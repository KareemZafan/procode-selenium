package automation_exercise;

import base_test.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTests extends BaseTests {
    @Test
    void testAdvertisementIsVisible() {
        homePage.navigateTo("Products");
        assertTrue(elementActions.isDisplayed(By.cssSelector("img#sale_image")));
    }

    @Test
    void testCartIsEmpty() {
        homePage.navigateTo("Cart");
        assertTrue(elementActions.getElementText(By.id("empty_cart")).contains("Cart is empty!"));
    }
}
