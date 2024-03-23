package pages;

import static com.codeborne.selenide.Selenide.$x;

public class StatusCodePage extends AbstractPage {

    private final String pageBodyXpath = "//div[@class='example']";

    public StatusCodePage() {
        super("Status Codes");
    }

    public StatusCodePage printTextFromPage() {
        System.out.println($x(pageBodyXpath).getText());
        return this;
    }
}
