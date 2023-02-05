import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import java.time.Duration;

public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    @Step("Preconditions for test")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Check that the Sauce section is active")
    @Description("Comparing the name of the selected section")
    public void menuSauceIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Check that the \"Fillings\" section is active")
    @Description("Comparing the name of the selected section")
    public void menuFillingsIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuFillings();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Check that the section \"Buns\" is active")
    @Description("Comparing the name of the selected section")
    public void menuBunIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce()
                .clickMenuBun();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @After
    @Step("Close browser")
    public void tearDown() {
        driver.quit();
    }
}
