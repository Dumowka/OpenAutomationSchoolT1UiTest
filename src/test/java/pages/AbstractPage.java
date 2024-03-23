package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public abstract class AbstractPage {

    private final String titleXpath;

    public AbstractPage(String title) {
        this.titleXpath = "//*[self::h3 or self::h1 and text()='%s']".formatted(title);
        waitForPageLoading();
    }

    protected void waitForPageLoading() {
        $x(titleXpath).shouldBe(visible);
    };
}
