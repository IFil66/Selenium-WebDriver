import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;

public class MainPageTest extends TestBase {

    final String urlPage = "http://localhost/litecart";
    final String locatorOfProductCard = ".product";
    final String locatorOfProductCardName = ".name";
    final String locatorOfStickerProductCard = ".sticker";

    @Test
    @DisplayName("Checking that product card has only one sticker")
    public void checkThatProductCardHasOnlyOneSticker() {
        driver.navigate().to(urlPage);
        List<WebElement> list = driver.findElements(cssSelector(locatorOfProductCard));
        for (WebElement element : list) {
            int stickerNumber = element.findElements(cssSelector(locatorOfStickerProductCard)).size();
            Assertions.assertEquals(1, stickerNumber,
                    "Product card with name: '"
                            + element.findElement(cssSelector(locatorOfProductCardName)).getText()
                            + "' hasn't only one sticker");
        }
    }
}