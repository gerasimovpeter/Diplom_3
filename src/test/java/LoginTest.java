import io.qameta.allure.Description;
import pom.MainPage;
import pom.PasswordRecoverPage;
import pom.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


public class LoginTest extends BeforeAndAfterTest {
    @Test
    @DisplayName("Checking the login by \"Sign in\" button on the main page")
    @Description("Check that the main page is displayed with \"Checkout\"")
    public void loginFromMainePageByEnterAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickAccountButton()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Checking the login by \"Entrance\" on the register page")
    @Description("Check that the main page is displayed with \"Checkout\"")
    public void loginFromRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage()
                .clickEnterButtonOnRegistrationPage()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Checking the login by \"Entrance\" on the recovery page")
    @Description("Check that the main page is displayed with \"Checkout\"")
    public void loginFromRecoveryPage() {
        PasswordRecoverPage passwordRecoverPage = new PasswordRecoverPage(driver);
        passwordRecoverPage.openRecoveryPage()
                .clickEnterButtonOnRecoveryPage()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }
    @Test
    @DisplayName("Checking the login using the \"Personal Area\" button on the main page")
    @Description("Check that the main page is displayed with \"Checkout\"")
    public void loginFromMainPageProfileButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButton()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isManePageOpen());
    }
}
