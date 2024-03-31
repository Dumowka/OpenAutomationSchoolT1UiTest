package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class InfiniteScrollPage extends AbstractPage {

    private final ElementsCollection blocksWithText = $$x("//div[@class='jscroll-added']");

    private final Actions action = new Actions(getWebDriver());

    public InfiniteScrollPage() {
        super("Infinite Scroll");
    }

    public InfiniteScrollPage scrollToElementWithText(String text) {
        while (blocksWithText.filter(matchText(text)).size() == 0) {
            action.scrollByAmount(0, 1000).perform();
        }
        blocksWithText.filter(matchText(text)).get(0).scrollIntoView(true).shouldBe(visible);
        return this;
    }
}
