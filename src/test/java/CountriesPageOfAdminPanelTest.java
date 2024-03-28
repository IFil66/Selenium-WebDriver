import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;

public class CountriesPageOfAdminPanelTest extends TestBase {
    final AdminAuthorizationPageTest adminAuthorizationPage = new AdminAuthorizationPageTest();
    final String pageUrl = "http://localhost/litecart/admin/?app=countries&doc=countries";
    final String allRowCountryNameTable = ".row";
    final String allLinksWithCountryName = ".row td:nth-child(5) a";
    final String countryName = "td:nth-child(5) a";
    final String countOfZone = "td:nth-child(6)";
    final String allZonesOfCountry = "#table-zones tr:not(:last-child) td:nth-child(3)";

    @Test
    @DisplayName("Проверка сортировки названий стран по алфавиту")
    public void getCountryNamesListAndCheckIfItIsSortedAlphabetically() {
        adminAuthorizationPage.goToAdminPageAndLoginThere(driver, pageUrl);
        List<String> countryNamesList = driver.findElements(cssSelector(allLinksWithCountryName)).stream()
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

    @Test
    @DisplayName("Проверка сортировки геозон в странах по алфавиту")
    public void getZoneNamesListAndCheckIfItIsSortedAlphabetically() {
        adminAuthorizationPage.goToAdminPageAndLoginThere(driver, pageUrl);
        List<WebElement> webElements = driver.findElements(cssSelector(allRowCountryNameTable));
        List<String> countryLinkList = webElements.stream()
                .filter(element -> Integer.parseInt(element.findElement(cssSelector(countOfZone)).getText()) > 0)
                .map(element -> element.findElement(cssSelector(countryName)).getAttribute("href"))
                .toList();
        for (String link : countryLinkList) {
            driver.navigate().to(link);
            List<String> zoneNameList = driver.findElements(cssSelector(allZonesOfCountry)).stream()
                    .map(WebElement::getText)
                    .toList();
            List<String> sortedZoneNameList = zoneNameList.stream()
                    .sorted()
                    .toList();
            for (int i = 0; i < zoneNameList.size(); i++) {
                Assertions.assertEquals(sortedZoneNameList.get(i), zoneNameList.get(i),
                        "The list of zone name is not sorted alphabetically");
            }
        }
    }
}