package pages;

import element_actions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
    private WebDriver driver;
    private Element elementActions;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        elementActions = new Element(driver);
    }

    public void register(String name, String email) {
        elementActions.type(By.cssSelector("div.signup-form input[name='name']"), name);
        elementActions.type(By.cssSelector("div.signup-form input[name='email']"), email);
        elementActions.click(By.cssSelector("div.signup-form button"));
    }

    public void enterTitle(Gender gender) {
        switch (gender) {
            case MALE:
                elementActions.click(By.id("id_gender1"));
                break;
            case FEMALE:
                elementActions.click(By.id("id_gender2"));
                break;
        }

    }

    public void enterName(String name) {
        elementActions.clear(By.id("name"));
        elementActions.type(By.id("name"), name);
    }

    public void enterEmail(String email) {
        elementActions.clear(By.id("email"));
        elementActions.type(By.id("email"), email);
    }

    public void enterPassword(String password) {
        elementActions.clear(By.id("password"));
        elementActions.type(By.id("password"), password);
    }

    public void selectYear(String year) {
        elementActions.selectOptionWithVisibleText(By.id("years"), year);
    }

    public void selectMonth(String month) {
        elementActions.selectOptionWithVisibleText(By.id("months"), month);
    }

    public void selectDay(String day) {
        elementActions.selectOptionWithVisibleText(By.id("days"), day);
    }

    public void selectOptionWithText(String text) {
        elementActions.click(By.xpath(String.format("//label[contains(text(),'%s')]/..//input", text)));
    }

    public void enterFirstName(String firstName) {
        elementActions.type(By.id("first_name"), firstName);
    }

    public void enterLastName(String lastName) {
        elementActions.type(By.id("last_name"), lastName);
    }

    public void enterCompany(String company) {
        elementActions.type(By.id("company"), company);
    }

    public void enterAddress1(String address) {
        elementActions.type(By.id("address1"), address);
    }

    public void selectCountry(String country) {
        elementActions.selectOptionWithVisibleText(By.id("country"), country);
    }

    public void enterState(String state) {
        elementActions.type(By.id("state"), state);
    }

    public void enterCity(String city) {
        elementActions.type(By.id("city"), city);
    }

    public void enterZipCode(String zipCode) {
        elementActions.type(By.id("zipcode"), zipCode);
    }

    public void enterMobileNumber(String mobile) {
        elementActions.type(By.id("mobile_number"), mobile);
    }

    public void clickCreateAccount() {
        elementActions.click(By.cssSelector("button[data-qa='create-account']"));
    }

    public boolean isAccountCreated() {
        return elementActions.
                getElementText(By.cssSelector("h2[data-qa='account-created'] > b"))
                .equalsIgnoreCase("ACCOUNT CREATED!");
    }

    public enum Gender {
        MALE, FEMALE
    }
}
