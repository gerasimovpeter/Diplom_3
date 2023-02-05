package pom;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static org.example.Urls.RECOVERY_PASSWORD_URL;
import org.openqa.selenium.WebDriver;


public class PasswordRecoverPage {
    private static final By enterButtonOnRecoverPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public PasswordRecoverPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Opening recovery page")
    public PasswordRecoverPage openRecoveryPage() {
        driver.get(RECOVERY_PASSWORD_URL);
        return this;
    }

    @Step("Clicking on \"Login\" button from recovery page")
    public LoginPage clickEnterButtonOnRecoveryPage() {
        driver.findElement(enterButtonOnRecoverPage).click();
        return new LoginPage(driver);
    }
}
