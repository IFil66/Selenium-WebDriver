import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class TestBase {
    public WebDriver driver;

    @BeforeEach
    public void start() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

//        SafariOptions options = new SafariOptions();
//        driver = new SafariDriver(options);

//        EdgeOptions options = new EdgeOptions();
//        driver = new EdgeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}