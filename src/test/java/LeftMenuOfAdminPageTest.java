import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;

public class LeftMenuOfAdminPageTest extends TestBase {
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    final AdminAuthorizationPageTest adminAuthorizationPage = new AdminAuthorizationPageTest();
    final String pageUrl = "http://localhost/litecart/admin";
    final String locatorOfAllTabs = "#app-";
    final String locatorOfInternalTab = "ul.docs li";


    @Test
    @DisplayName("Проверка работы кнопок левого навигационного меню панели админа")
    public void checkingButtonsOfLeftNavigationMenuAdminPanel() {
        goToAdminPageAndLoginThere();

        int numberTabs = driver.findElements(cssSelector(locatorOfAllTabs)).size();
        for (int i = 1; i <= numberTabs; i++) {
            driver.findElement(cssSelector(locatorOfAllTabs + ":nth-child(" + i + ")")).click();
            Assertions.assertTrue(driver.findElement(cssSelector("h1")).isDisplayed());
            int numberInternalTabs = driver.findElements(cssSelector(locatorOfInternalTab)).size();
            if (numberInternalTabs > 0) {
                for (int n = 1; n <= numberInternalTabs; n++) {
                    driver.findElement(cssSelector(locatorOfInternalTab + ":nth-child(" + n + ")")).click();
                    Assertions.assertTrue(driver.findElement(cssSelector("h1")).isDisplayed());
                }
            }
        }
    }

    private void goToAdminPageAndLoginThere() {
        driver.navigate().to(adminAuthorizationPage.pageUrl);
        driver.findElement(cssSelector(adminAuthorizationPage.locatorOfUserNameField))
                .sendKeys(adminAuthorizationPage.adminLogin);
        driver.findElement(cssSelector(adminAuthorizationPage.locatorOfPasswordField))
                .sendKeys(adminAuthorizationPage.adminPassword);
        driver.findElement(cssSelector(adminAuthorizationPage.locatorOfLoginButton)).click();
        WebElement successNoticeElement =
                driver.findElement(cssSelector(adminAuthorizationPage.locatorOfSuccessNoticeText));
        wait.until(e -> successNoticeElement.isDisplayed());
        Assumptions.assumeTrue(driver.getCurrentUrl().contains(pageUrl), "Current page hasn't URL: " + pageUrl);
    }
}