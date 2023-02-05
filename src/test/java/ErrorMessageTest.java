import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import data.User;
import data.GeneratorForUsers;
import pom.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import java.time.Duration;
import static org.example.Urls.ERROR_MESSAGE_OF_WRONG_PASSWORD;
import static pom.RegistrationPage.registerWrongPasswordMessageInRegisterPage;

public class ErrorMessageTest {
    private WebDriver driver;
    private User user;

    @Before
    @Step("Precondition step for test")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = GeneratorForUsers.getNewRandomUser();
    }

    @Test
    @DisplayName("Try create new order with wrong password")
    @Description("Tap in password field 3 numbers")
    public void shownErrorMessageWithIncorrectPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage()
                .enterRegisterName(user.getName())
                .enterRegisterEmail(user.getEmail())
                .enterRegisterPassword("123")
                .clickRegistrationButton();
        Assert.assertEquals("Ошибка не появилась", ERROR_MESSAGE_OF_WRONG_PASSWORD,
                driver.findElement(registerWrongPasswordMessageInRegisterPage).getText());
    }

    @After
    @Step("Close browser")
    public void tearDown() {
        driver.quit();
    }
}
