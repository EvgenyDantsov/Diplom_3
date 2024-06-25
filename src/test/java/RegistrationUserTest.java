import factory.WebDriverUtil;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.MainPage;
import page.RegistrationPage;
import step.UserStep;
import user.User;
import util.BaseTest;

import static org.junit.Assert.assertTrue;

public class RegistrationUserTest extends BaseTest {
    //Константа для выбора браузера в котором тестируем
    private static final String BROWSER = "chrome";
    private static final String URL_STELLAR_BURGERS = "https://stellarburgers.nomoreparties.site/register";
    private WebDriver driver;
    private UserStep userStep;
    private User user;
    private User userPasswordLessSix;
    private boolean isUserRegistered;
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Before
    public void webDriver() {
        driver = WebDriverUtil.getWebDriver(BROWSER);
        user = new User("diplom2@mail.ru", "test1234", "Evgeny");
        userPasswordLessSix = new User("diplom2@mail.ru", "pass", "Evgeny");
        driver.get(URL_STELLAR_BURGERS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        userStep = new UserStep();
        isUserRegistered = false;
    }

    @Test
    @DisplayName("Check successful registration")
    public void checkOfSuccessfulRegistrationTest() {
        registrationPage.setRegistrationForm(user);
        loginPage.setLoginForm(user);
        assertTrue("Не появилась кнопка 'Оформить заказ'", mainPage.createOrderButtonIsDisplayed());
        isUserRegistered = true;
    }

    @Test
    @DisplayName("Error for password less than six characters")
    public void shouldThrowErrorForPasswordLessThanSixCharacters() {
        registrationPage.setRegistrationForm(userPasswordLessSix);
        assertTrue("Не появился текст 'Некорректный пароль'", registrationPage.errorPasswordTextIsDisplayed());
    }

    @After
    public void quitBrowser() {
        // Закрываем браузер
        WebDriverUtil.quitDriver(driver);
        if (isUserRegistered) {
            userStep.deleteUser(userStep.getUserToken(user.getEmail(), user.getPassword()));
        }
    }
}