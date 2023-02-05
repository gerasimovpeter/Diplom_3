import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import data.User;
import data.GeneratorForUsers;
import org.openqa.selenium.chrome.ChromeOptions;
import user.UserClient;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BeforeAndAfterTest {
    User user;
    String accessToken;
    WebDriver driver;
    UserClient userClient;

    @Before
    @Step("Precondition step")
    public void setUp() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = GeneratorForUsers.getNewRandomUser();
        userClient = new UserClient();
        ValidatableResponse responseCreateUser = userClient.createUser(user);
        accessToken = responseCreateUser.extract().path("accessToken").toString().substring(7);
    }

    @After
    @Step("Delete User and Close browser")
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}
