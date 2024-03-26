package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StatusCodePage extends AbstractPage {

    private final SelenideElement pageBody = $x("//div[@class='example']");

    public StatusCodePage() {
        super("Status Codes");
    }

    public StatusCodePage printTextFromPage() {
        System.out.println(pageBody.getText());
        return this;
    }
}
