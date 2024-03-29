package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$x;

public class StatusCodePage extends AbstractPage {

    private final SelenideElement pageBody = $x("//div[@class='example']").as("Тело страницы");

    public StatusCodePage() {
        super("Status Codes");
    }

    public StatusCodePage printTextFromPage() {
        System.out.println(pageBody.getText());
        return this;
    }

    public StatusCodePage checkThatCorrectPageIsOpened(String expectedTextOnPage) {
        pageBody.shouldHave(matchText(expectedTextOnPage));
        return this;
    }
}
