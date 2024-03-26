package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StatusCodesPage extends AbstractPage {

    private final SelenideElement okStatusCodeLink = $x("//a[@href='status_codes/200']");
    private final SelenideElement movedPermanentlyStatusCodeLink = $x("//a[@href='status_codes/301']");
    private final SelenideElement notFoundStatusCodeLink = $x("//a[@href='status_codes/404']");
    private final SelenideElement internalServerErrorStatusCodeLink = $x("//a[@href='status_codes/500']");

    public StatusCodesPage() {
        super("Status Codes");
    }

    public StatusCodePage clickOnOkStatusCodeLink() {
        okStatusCodeLink.click();
        return new StatusCodePage();
    }

    public StatusCodePage clickOnMovedPermanentlyStatusCodeLink() {
        movedPermanentlyStatusCodeLink.click();
        return new StatusCodePage();
    }

    public StatusCodePage clickOnNotFoundStatusCodeLink() {
        notFoundStatusCodeLink.click();
        return new StatusCodePage();
    }

    public StatusCodePage clickOnInternalServerErrorStatusCodeLink() {
        internalServerErrorStatusCodeLink.click();
        return new StatusCodePage();
    }
}
