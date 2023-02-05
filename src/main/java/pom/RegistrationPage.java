package pom;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.User;
import static org.example.Urls.REGISTER_PAGE_URL;

public class RegistrationPage {
    private final WebDriver driver;
    public static By registerWrongPasswordMessageInRegisterPage = By.xpath(".//p[text()='Некорректный пароль']");
    private static final By registerName = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private static final By registerEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By enterButtonOnRegistrationPage = By.xpath(".//*[text()='Войти']"); //кнопка "войти" на форме регистрации

    private static final By registerPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Opening register page")
    public RegistrationPage openRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
        return this;
    }

    @Step("Enter name on register page")
    public RegistrationPage enterRegisterName(String name) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(name);
        return this;
    }

    @Step("Enter email on register page")
    public RegistrationPage enterRegisterEmail(String email) {
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(email);
        return this;
    }

    @Step("Enter password on register page")
    public RegistrationPage enterRegisterPassword(String password) {
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(password);
        return this;
    }

    @Step("Clicking on \"Register\" button on register page")
    public LoginPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new LoginPage(driver);
    }

    @Step("Clicking on \"Login\" button on register page")
    public LoginPage clickEnterButtonOnRegistrationPage() {
        driver.findElement(enterButtonOnRegistrationPage).click();
        return new LoginPage(driver);
    }

    @Step("Register new user with credentials. Fill forms")
    public RegistrationPage registerNewUser(User user) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(user.getName()); //enter name
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(user.getEmail()); //enter e-mail
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(user.getPassword()); // enter password
        return this;
    }
}