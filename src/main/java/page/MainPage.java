package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final By personalAccount = By.xpath("//a[@class='AppHeader_header__link__3D_hX' and contains(@href, '/account')]");
    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath("//button[(text()='Оформить заказ')]");
    private final By collectBurgersText = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/h1[text()='Соберите бургер']");
    private final By bunsTab = By.xpath("//span[contains(@class, 'text_type_main-default') and text()='Булки']");
    private final By bunsText = By.xpath("//h2[contains(@class, 'text_type_main-medium') and text()='Булки']");
    private final By saucesTab = By.xpath("//span[contains(@class, 'text_type_main-default') and text()='Соусы']");
    private final By saucesText = By.xpath("//h2[contains(@class, 'text_type_main-medium') and text()='Соусы']");
    private final By fillingsTab = By.xpath("//span[contains(@class, 'text_type_main-default') and text()='Начинки']");
    private final By fillingsText = By.xpath("//h2[contains(@class, 'text_type_main-medium') and text()='Начинки']");
    //Объект WebDriver, используется для взаимодействия с браузером
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginUserClick() {
        driver.findElement(loginAccountButton).click();
    }

    public void personalAccountClick() {
        driver.findElement(personalAccount).click();
    }

    public void bunsTabClick() {
        driver.findElement(bunsTab).click();
    }

    public void saucesTabClick() {
        driver.findElement(saucesTab).click();
    }

    public void fillingsTabClick() {
        driver.findElement(fillingsTab).click();
    }

    public boolean bunsTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(bunsText));
        return driver.findElement(bunsText).isDisplayed();
    }

    public boolean createOrderButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }

    public boolean collectBurgersTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(collectBurgersText));
        return driver.findElement(collectBurgersText).isDisplayed();
    }

    public boolean saucesTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(saucesText));
        return driver.findElement(saucesText).isDisplayed();
    }

    public boolean fillingsTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(fillingsText));
        return driver.findElement(fillingsText).isDisplayed();
    }
}