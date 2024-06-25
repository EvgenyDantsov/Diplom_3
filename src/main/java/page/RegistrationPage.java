package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class RegistrationPage {
    private final By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By registerFormTextTitle = By.xpath("//h2[text()='Регистрация']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorWrongPasswordText = By.xpath("//div[@class='input__container']//p[text() = 'Некорректный пароль']");
    private final By logLink = By.xpath("//a[@class='Auth_link__1fOlj' and contains(@href, '/login')]");

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Set the registration form with user details and submit")
    public void setRegistrationForm(User user) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(registerFormTextTitle));
        driver.findElement(nameField).sendKeys(user.getName());
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(registerButton).click();
    }

    @Step("Check if the error message for incorrect password is displayed")
    public boolean errorPasswordTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(errorWrongPasswordText));
        return driver.findElement(errorWrongPasswordText).isDisplayed();
    }

    @Step("Click on the login link")
    public void logLinkClick() {
        driver.findElement(logLink).click();
    }
}