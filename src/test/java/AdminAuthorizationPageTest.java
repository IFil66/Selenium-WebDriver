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

public class AdminAuthorizationPageTest extends TestBase {
    final String url = "http://localhost/litecart/admin/";
    final String adminLogin = "admin";
    final String adminPassword = "admin";

    final String locatorOfUserNameText = "div.content tbody tr:nth-child(1) td:nth-child(1)";
    final String locatorOfUserNameField = "div.content tbody tr:nth-child(1) td:nth-child(2) input";
    final String locatorOfPasswordText = "div.content tbody tr:nth-child(2) td:nth-child(1)";
    final String locatorOfPasswordField = "div.content tbody tr:nth-child(2) td:nth-child(2) input";
    final String locatorOfLoginButton = "button[name='login']";
    final String locatorOfErrorNoticeText = ".notice.errors";
    final String locatorOfSuccessNoticeText = ".notice.success";

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));


    @Test
    @DisplayName("Проверка названия полей и кнопки формы авторизации Админа")
    public void checkNameFieldsOfAuthorizationPanelTest() {
        driver.navigate().to(url);

        String actualUserNameFieldText = driver.findElement(cssSelector(locatorOfUserNameText)).getText();
        String actualPasswordFieldText = driver.findElement(cssSelector(locatorOfPasswordText)).getText();
        String actualNameLoginButton = driver.findElement(cssSelector(locatorOfLoginButton)).getText();

        Assertions.assertEquals("Username", actualUserNameFieldText);
        Assertions.assertEquals("Password", actualPasswordFieldText);
        Assertions.assertEquals("Login", actualNameLoginButton);
    }

    @Test
    @DisplayName("Проверка текста уведомления об успешной авторизации за админа")
    public void checkSuccessNoticeTextWhenSuccessfulAuthorizationToAdminPanelTest() {
        goToAdminPageAndLoginThere(driver, url);

        WebElement successNoticeElement = driver.findElement(cssSelector(locatorOfSuccessNoticeText));
        wait.until(e -> successNoticeElement.isDisplayed());
        String actualErrorNoticeText = successNoticeElement.getText();

        Assertions.assertEquals("You are now logged in as admin", actualErrorNoticeText);
    }

    @Test
    @DisplayName("Проверка текста уведомления об ошибке при авторизации с невалидными данными")
    public void checkErrorNoticeTextWhenUnsuccessfulAuthorizationToAdminPanelTest() {
        driver.navigate().to(url);

        driver.findElement(cssSelector(locatorOfUserNameField)).sendKeys("123");
        driver.findElement(cssSelector(locatorOfPasswordField)).sendKeys("123");
        driver.findElement(cssSelector(locatorOfLoginButton)).click();

        WebElement errorNoticeElement = driver.findElement(cssSelector(locatorOfErrorNoticeText));
        wait.until(e -> errorNoticeElement.isDisplayed());
        String actualErrorNoticeText = errorNoticeElement.getText();

        Assertions.assertEquals("The user could not be found in our database", actualErrorNoticeText);
    }

    public void goToAdminPageAndLoginThere(WebDriver driver, String pageUrl) {
        driver.navigate().to(pageUrl);
        driver.findElement(cssSelector(locatorOfUserNameField)).sendKeys(adminLogin);
        driver.findElement(cssSelector(locatorOfPasswordField)).sendKeys(adminPassword);
        driver.findElement(cssSelector(locatorOfLoginButton)).click();
        WebElement successNoticeElement = driver.findElement(cssSelector(locatorOfSuccessNoticeText));
        wait.until(e -> successNoticeElement.isDisplayed());
        Assumptions.assumeTrue(driver.getCurrentUrl().contains(pageUrl), "Current page hasn't URL: " + pageUrl);
    }
}