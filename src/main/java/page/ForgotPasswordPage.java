package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final By recoveryPasswordFormTextTitle = By.xpath("//h2[text()='Восстановление пароля']");
    private final By logLink = By.xpath("//a[@class='Auth_link__1fOlj' and contains(@href, '/login')]");
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the login link")
    public void logLinkClick() {
        driver.findElement(logLink).click();
    }
}