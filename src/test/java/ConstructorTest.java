import factory.WebDriverUtil;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.AccountProfilePage;
import page.MainPage;
import util.BaseTest;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {
    //Константа для выбора браузера в котором тестируем
    private static final String BROWSER = "chrome";
    private static final String URL_STELLAR_BURGERS = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;
    MainPage mainPage;
    AccountProfilePage accountProfilePage;

    @Before
    public void webDriver() {
        driver = WebDriverUtil.getWebDriver(BROWSER);
        driver.get(URL_STELLAR_BURGERS);
        mainPage = new MainPage(driver);
        accountProfilePage = new AccountProfilePage(driver);
    }

    @Test
    @DisplayName("Navigation to buns tab")
    public void bunsTabNavigationTest() {
        //Переходим на другой раздел, чтобы проверить работоспособность перехода на 'Булки'
        //т.к. в начале открытия страницы у нас по умолчанию открыт раздел 'Булки'
        mainPage.fillingsTabClick();
        mainPage.bunsTabClick();
        assertEquals("Не работает переход на 'Булки'", "Булки", mainPage.getActionTabText());
    }

    @Test
    @DisplayName("Navigation to sauces tab")
    public void saucesTabNavigationTest() {
        mainPage.saucesTabClick();
        assertEquals("Не работает переход на 'Соусы'", "Соусы", mainPage.getActionTabText());
    }

    @Test
    @DisplayName("Navigation to fillings tab")
    public void fillingsTabNavigationTest() {
        mainPage.fillingsTabClick();
        assertEquals("Не работает переход на 'Начинки'", "Начинки", mainPage.getActionTabText());
    }

    @After
    public void quitBrowser() {
        // Закрываем браузер
        WebDriverUtil.quitDriver(driver);
    }
}