package data;
import org.apache.commons.lang3.RandomStringUtils;

public class GeneratorForUsers {
    public static User getNewRandomUser() {
        return new User(RandomStringUtils.randomAlphanumeric(9),
                RandomStringUtils.randomAlphanumeric(9) + "@test.ru",
                RandomStringUtils.randomAlphanumeric(9));
    }
}
