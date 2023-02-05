package pom;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class ProfilePage {
    private static final By burgerLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private static final By goToConstructor = By.xpath(".//p[text()='Конструктор']"); // переход на главную страницу
    private static final By logOutButton = By.xpath(".//button[text()='Выход']");

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clicking on \"Constructor\" button from profile page")
    public MainPage clickConstructorButton() {
        driver.findElement(goToConstructor).click();
        return new MainPage(driver);
    }

    @Step("Clicking on Logo image from profile page")
    public MainPage clickOnLogo() {
        driver.findElement(burgerLogo).click();
        return new MainPage(driver);
    }

    @Step("Clicking on \"Exit\" button from profile page")
    public LoginPage clickLogOutButton() {
        driver.findElement(logOutButton).click();
        return new LoginPage(driver);
    }
}
