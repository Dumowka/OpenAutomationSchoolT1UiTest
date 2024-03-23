package pages;

import static com.codeborne.selenide.Selenide.$x;

public class StatusCodesPage extends AbstractPage {

    private final String okStatusCodeLinkXpath = "//a[@href='status_codes/200']";
    private final String movedPermanentlyStatusCodeLinkXpath = "//a[@href='status_codes/301']";
    private final String notFoundStatusCodeLinkXpath = "//a[@href='status_codes/404']";
    private final String internalServerErrorStatusCodeLinkXpath = "//a[@href='status_codes/500']";

    public StatusCodesPage() {
        super("Status Codes");
    }

    public StatusCodePage clickOnOkStatusCodeLink() {
        $x(okStatusCodeLinkXpath).click();
        return new StatusCodePage();
    }

    public StatusCodePage clickOnMovedPermanentlyStatusCodeLink() {
        $x(movedPermanentlyStatusCodeLinkXpath).click();
        return new StatusCodePage();
    }

    public StatusCodePage clickOnNotFoundStatusCodeLink() {
        $x(notFoundStatusCodeLinkXpath).click();
        return new StatusCodePage();
    }

    public StatusCodePage clickOnInternalServerErrorStatusCodeLink() {
        $x(internalServerErrorStatusCodeLinkXpath).click();
        return new StatusCodePage();
    }
}
