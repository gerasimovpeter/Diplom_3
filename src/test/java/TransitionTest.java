import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;
import java.time.Duration;import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import static org.example.Urls.LOGIN_PAGE_URL;
import static org.example.Urls.BASE_URL;

public class TransitionTest extends BeforeAndAfterTest {
    @Test
    @DisplayName("Switch from the personal account to the main page by Logo")
    @Description("Check that the main page is displayed")
    public void switchFromProfileByLogo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButton()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonFromAuthorizedUser()
                .clickOnLogo();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
    }


    @Test
    @DisplayName("Switch from the personal account to the main page by Constructor button")
    @Description("Check that the main page is displayed")
    public void switchFromProfileByConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButton()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonFromAuthorizedUser()
                .clickConstructorButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Switch to the personal account from he main page by \"Personal Area\" button by not authorized user")
    @Description("Check that the login page is displayed")
    public void clickOnProfileByUnauthorizedUserShowsLoginPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        Assert.assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

}
