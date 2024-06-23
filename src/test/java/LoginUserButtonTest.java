import factory.WebDriverUtil;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.MainPage;
import page.RegistrationPage;
import step.UserStep;
import user.User;
import util.BaseTest;

import static org.junit.Assert.assertTrue;

public class LoginUserButtonTest extends BaseTest {
    //Константа для выбора браузера в котором тестируем
    private static final String BROWSER = "chrome";
    private static final String URL_STELLAR_BURGERS = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;
    private UserStep userStep;
    private User user;
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ForgotPasswordPage forgotPasswordPage;

    @Before
    public void webDriver() {
        driver = WebDriverUtil.getWebDriver(BROWSER);
        user = new User("diplom2@mail.ru", "test1234", "Evgeny");
        driver.get(URL_STELLAR_BURGERS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        userStep = new UserStep();
        userStep.createUser(user);
    }

    @Test
    @DisplayName("Login from home page")
    public void loginFromHomePageTest() {
        mainPage.loginUserClick();
        loginPage.setLoginForm(user);
        assertTrue("Не появилась кнопка 'Оформить заказ'", mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Login from personal account button")
    public void loginFromPersonalAccountButtonTest() {
        mainPage.personalAccountClick();
        loginPage.setLoginForm(user);
        assertTrue("Не появилась кнопка 'Оформить заказ'", mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Login from registration form")
    public void loginFromRegistrationFormTest() {
        mainPage.loginUserClick();
        loginPage.registrationLinkClick();
        registrationPage.logLinkClick();
        loginPage.setLoginForm(user);
        assertTrue("Не появилась кнопка 'Оформить заказ'", mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Login from password recovery")
    public void loginFromPasswordRecoveryTest() {
        mainPage.loginUserClick();
        loginPage.forgotPasswordLinkClick();
        forgotPasswordPage.logLinkClick();
        loginPage.setLoginForm(user);
        assertTrue("Не появилась кнопка 'Оформить заказ'", mainPage.createOrderButtonIsDisplayed());
    }

    @After
    public void quitBrowser() {
        // Закрываем браузер
        WebDriverUtil.quitDriver(driver);
        userStep.deleteUser(userStep.getUserToken(user.getEmail(), user.getPassword()));
    }
}