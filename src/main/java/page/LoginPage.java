package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class LoginPage {
    private final By emailField = By.xpath("//label[text() = 'Email']/following-sibling::input");
    private final By passwordField = By.xpath("//label[text() = 'Пароль']/following-sibling::input");
    private final By loginButton = By.xpath("//div[@class='Auth_login__3hAey']//button[text()='Войти']");
    private final By registrationLink = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    private final By forgotPasswordLink = By.xpath("//a[@class='Auth_link__1fOlj' and contains(@href, '/forgot-password')]");
    private final By loginFormTextTitle = By.xpath("//h2[text()='Вход']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Set the login form with user credentials and submit")
    public void setLoginForm(User user) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loginFormTextTitle));
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(loginButton).click();
    }

    @Step("Click on the registration link")
    public void registrationLinkClick() {
        driver.findElement(registrationLink).click();
    }

    @Step("Click on the forgot password link")
    public void forgotPasswordLinkClick() {
        driver.findElement(forgotPasswordLink).click();
    }

    @Step("Check if the login form text title is displayed")
    public boolean loginFormTextTitleIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loginFormTextTitle));
        return driver.findElement(loginFormTextTitle).isDisplayed();
    }
}