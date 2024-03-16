import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAuthorizationPageTest extends TestBase {
    final String pageUrl = "http://localhost/litecart/admin/";
    final String locatorOfUserNameText = "div.content tbody tr:nth-child(1) td:nth-child(1)";
    final String locatorOfUserNameField = "div.content tbody tr:nth-child(1) td:nth-child(2) input";
    final String locatorOfPasswordText = "div.content tbody tr:nth-child(2) td:nth-child(1)";
    final String locatorOfPasswordField = "div.content tbody tr:nth-child(2) td:nth-child(2) input";
    final String locatorOfLoginButton = "button[name='login']";
    final String locatorOfErrorNoticeText = "#notices div";

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));


    @Test
    @DisplayName("Проверка названия полей и кнопки формы авторизации Админа")
    public void checkNameFieldsOfAuthorizationPanelTest() {
        driver.navigate().to(pageUrl);

        String actualUserNameFieldText = driver.findElement(By.cssSelector(locatorOfUserNameText)).getText();
        String actualPasswordFieldText = driver.findElement(By.cssSelector(locatorOfPasswordText)).getText();
        String actualNameLoginButton = driver.findElement(By.cssSelector(locatorOfLoginButton)).getText();

        Assertions.assertEquals("Username", actualUserNameFieldText);
        Assertions.assertEquals("Password", actualPasswordFieldText);
        Assertions.assertEquals("Login", actualNameLoginButton);
    }

    @Test
    @DisplayName("Проверка текста уведомления об ошибке при авторизации с невалидными данными")
    public void checkErrorNoticeTextWhenUnsuccessfulAuthorizationToAdminPanelTest() {
        driver.navigate().to(pageUrl);

        driver.findElement(By.cssSelector(locatorOfUserNameField)).sendKeys("123");
        driver.findElement(By.cssSelector(locatorOfPasswordField)).sendKeys("123");
        driver.findElement(By.cssSelector(locatorOfLoginButton)).click();
        WebElement errorNoticeElement = driver.findElement(By.cssSelector(locatorOfErrorNoticeText));
        wait.until(e -> errorNoticeElement.isDisplayed());
        String actualErrorNoticeText = errorNoticeElement.getText();

        Assertions.assertEquals("The user could not be found in our database", actualErrorNoticeText);
    }
}