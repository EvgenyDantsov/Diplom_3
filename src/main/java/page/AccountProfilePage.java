package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountProfilePage {
    private final By accountProfileText = By.xpath("//p[@class='Account_text__fZAIn text text_type_main-default' and contains(text(), 'В этом разделе')]");
    private final By stellarBurgersTextLink = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");
    private final By constructorTextLink = By.xpath("//a[@class='AppHeader_header__link__3D_hX']//p[text()='Конструктор']");
    private final By exitButton = By.xpath("//button[contains(@class, 'Account_button__14Yp3') and text()='Выход']");
    private final WebDriver driver;

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check if the Account Profile form is displayed")
    public boolean openAccountProfileFormIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(accountProfileText));
        return driver.findElement(accountProfileText).isDisplayed();
    }

    @Step("Click on the Stellar Burgers text link")
    public void stellarBurgersTextLinkClick() {
        driver.findElement(stellarBurgersTextLink).click();
    }

    @Step("Click on the Constructor text link")
    public void constructorTextLinkClick() {
        driver.findElement(constructorTextLink).click();
    }

    @Step("Click on the Exit button")
    public void exitButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }
}