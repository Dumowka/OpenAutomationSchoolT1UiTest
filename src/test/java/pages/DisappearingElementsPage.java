package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElementsPage extends AbstractPage {

    private final String homeLinkXpath = "//a[@href='/']";
    private final String aboutLinkXpath = "//a[@href='/about/']";
    private final String contactUsLinkXpath = "//a[@href='/contact-us/']";
    private final String portfolioLinkXpath = "//a[@href='/portfolio/']";
    private final String galleryLinkXpath = "//a[@href='/gallery/']";

    public DisappearingElementsPage() {
        super("Disappearing Elements");
    }

    public boolean checkThatAllLinksIsAppear() {
        return $x(homeLinkXpath).isDisplayed() &&
                $x(aboutLinkXpath).isDisplayed() &&
                $x(contactUsLinkXpath).isDisplayed() &&
                $x(portfolioLinkXpath).isDisplayed() &&
                $x(galleryLinkXpath).isDisplayed();
    }
}
