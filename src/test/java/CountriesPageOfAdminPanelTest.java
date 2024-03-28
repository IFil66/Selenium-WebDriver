import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;

public class CountriesPageOfAdminPanelTest extends TestBase {
    final AdminAuthorizationPageTest adminAuthorizationPage = new AdminAuthorizationPageTest();
    final String pageUrl = "http://localhost/litecart/admin/?app=countries&doc=countries";
    final String locatorOfAllLinksWithCountryName = ".row td:nth-child(5) a";

    @Test
    @DisplayName("Проверка сортировки названий стран по алфавиту")
    public void getCountryNamesListAndCheckIfItIsSortedAlphabetically() {
        adminAuthorizationPage.goToAdminPageAndLoginThere(driver, pageUrl);
        List<String> countryNamesList = driver.findElements(cssSelector(locatorOfAllLinksWithCountryName)).stream()
                .map(WebElement::getText)
                .toList();
        List<String> sortedCountryNamesList = countryNamesList.stream()
                .sorted()
                .toList();
        for (int i = 0; i < countryNamesList.size(); i++) {
            Assertions.assertEquals(sortedCountryNamesList.get(i), countryNamesList.get(i),
                    "The list of countries name is not sorted alphabetically");
        }
    }
}