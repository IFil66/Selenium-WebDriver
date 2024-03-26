import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class MainPageTest extends TestBase {

    final String urlPage = "http://localhost/litecart";

    final String locatorOfMostPopularItemsPartFirst = "//h3[text() = '";
    final String locatorOfMostPopularItemsPartSecond = "']/following-sibling::div//li";
    final String locatorOfStickerItem = "a div.sticker";
    final String locatorOfNameItem = "a div.name";


    @ParameterizedTest(name = "Checking that {0} items has only one sticker")
    @ValueSource(strings = {
            "Most Popular",
            "Campaigns",
            "Latest Products"})
    public void checkThatItemsHasOnlyOneSticker(String sectionName) {
        driver.navigate().to(urlPage);
        List<WebElement> list = driver.findElements(xpath(
                locatorOfMostPopularItemsPartFirst + sectionName + locatorOfMostPopularItemsPartSecond));
        for (WebElement element : list) {
            int stickerNumber = element.findElements(cssSelector(locatorOfStickerItem)).size();
            Assertions.assertEquals(1, stickerNumber,
                    "Item with name: "
                            + element.findElement(cssSelector(locatorOfNameItem)).getText()
                            + " in section: " + sectionName
                            + " hasn't only one sticker");
        }
    }
}