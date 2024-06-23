import factory.WebDriverUtil;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.AccountProfilePage;
import page.LoginPage;
import page.MainPage;
import step.UserStep;
import user.User;
import util.BaseTest;

import static org.junit.Assert.assertTrue;

public class PersonalAccountToConstructorTransitionTest extends BaseTest {
    //Константа для выбора браузера в котором тестируем
    private static final String BROWSER = "chrome";
    private static final String URL_STELLAR_BURGERS = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;
    private UserStep userStep;
    private User user;
    MainPage mainPage;
    LoginPage loginPage;
    AccountProfilePage accountProfilePage;

    @Before
    public void webDriver() {
        driver = WebDriverUtil.getWebDriver(BROWSER);
        user = new User("diplom2@mail.ru", "test1234", "Evgeny");
        driver.get(URL_STELLAR_BURGERS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        accountProfilePage = new AccountProfilePage(driver);
        userStep = new UserStep();
        userStep.createUser(user);
    }

    @Test
    @DisplayName("Constructor link navigation")
    public void constructorLinkNavigationTest() {
        mainPage.loginUserClick();
        loginPage.setLoginForm(user);
        mainPage.personalAccountClick();
        accountProfilePage.constructorTextLinkClick();
        assertTrue("Не удалось перейти к конструктору", mainPage.collectBurgersTextIsDisplayed());
    }

    @Test
    @DisplayName("Stellar Burgers link navigation")
    public void stellarBurgersLinkNavigationTest() {
        mainPage.loginUserClick();
        loginPage.setLoginForm(user);
        mainPage.personalAccountClick();
        accountProfilePage.stellarBurgersTextLinkClick();
        assertTrue("Не удалось перейти к конструктору", mainPage.collectBurgersTextIsDisplayed());
    }

    @After
    public void quitBrowser() {
        // Закрываем браузер
        WebDriverUtil.quitDriver(driver);
        userStep.deleteUser(userStep.getUserToken(user.getEmail(), user.getPassword()));
    }
}