package pom;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.example.Urls.LOGIN_PAGE_URL;
import java.time.Duration;

public class LoginPage {
    private static final By loginEnterButton = By.xpath(".//*[text()='Войти']");
    private static final By loginEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By loginPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By registerWrongPasswordMessageInLoginPage = By.xpath(".//p[text()='Некорректный пароль']");
    private static final By registerButtonFromLogin = By.xpath(".//*[text()='Зарегистрироваться']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Opening the authorization page")
    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    @Step("Clicking on the register button")
    public RegistrationPage clickRegisterButtonLoginPage() {
        driver.findElement(registerButtonFromLogin).click();
        return new RegistrationPage(driver);
    }

    @Step("Clicking on Entrance button on login page")
    public MainPage clickLoginEnterButton() {
        driver.findElement(loginEnterButton).click();
        return new MainPage(driver);
    }

    @Step("Filling out the authorization form")
    public LoginPage authorizationFromLoginPage(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        driver.findElement(loginEmail).click();
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).click();
        driver.findElement(loginPassword).sendKeys(password);
        return this;
    }
}
