import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.openqa.selenium.By.cssSelector;

public class LeftMenuOfAdminPanelTest extends TestBase {
    final AdminAuthorizationPageTest adminAuthorizationPage = new AdminAuthorizationPageTest();
    final String pageUrl = "http://localhost/litecart/admin";
    final String locatorOfAllTabs = "#app-";
    final String locatorOfInternalTab = "ul.docs li";


    @Test
    @DisplayName("Проверка работы кнопок левого навигационного меню панели админа")
    public void checkingButtonsOfLeftNavigationMenuAdminPanel() {
        adminAuthorizationPage.goToAdminPageAndLoginThere(driver, pageUrl);

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
}