import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest extends TestBase {
    final String pageUrl = "https://ya.ru";

    @Test
    public void myFirstTest() {
        driver.navigate().to(pageUrl);
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains(pageUrl));
    }
}