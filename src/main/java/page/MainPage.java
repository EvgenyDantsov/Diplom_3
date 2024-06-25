package page;

import io.qameta.allure.Step;
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
    private final By saucesTab = By.xpath("//span[contains(@class, 'text_type_main-default') and text()='Соусы']");
    private final By fillingsTab = By.xpath("//span[contains(@class, 'text_type_main-default') and text()='Начинки']");
    // Локатор для активной вкладки
    private final By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    //Объект WebDriver, используется для взаимодействия с браузером
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on login user button")
    public void loginUserClick() {
        driver.findElement(loginAccountButton).click();
    }

    @Step("Click on personal account button")
    public void personalAccountClick() {
        driver.findElement(personalAccount).click();
    }

    @Step("Click on buns tab")
    public void bunsTabClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(bunsTab));
        driver.findElement(bunsTab).click();
    }

    @Step("Click on sauces tab")
    public void saucesTabClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();
    }

    @Step("Click on fillings tab")
    public void fillingsTabClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(fillingsTab));
        driver.findElement(fillingsTab).click();
    }

    @Step("Check if create order button is displayed")
    public boolean createOrderButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Check if collect burgers text is displayed")
    public boolean collectBurgersTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(collectBurgersText));
        return driver.findElement(collectBurgersText).isDisplayed();

    }

    @Step("Get text of the active tab")
    public String getActionTabText() {
        return driver.findElement(activeTab).getText();
    }
}