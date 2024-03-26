package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElementsPage extends AbstractPage {

    private final SelenideElement homeLink = $x("//a[@href='/']");
    private final SelenideElement aboutLink = $x("//a[@href='/about/']");
    private final SelenideElement contactUsLink = $x("//a[@href='/contact-us/']");
    private final SelenideElement portfolioLink = $x("//a[@href='/portfolio/']");
    private final SelenideElement galleryLink = $x("//a[@href='/gallery/']");

    public DisappearingElementsPage() {
        super("Disappearing Elements");
    }

    public boolean checkThatAllLinksIsAppear() {
        return homeLink.isDisplayed() &&
                aboutLink.isDisplayed() &&
                contactUsLink.isDisplayed() &&
                portfolioLink.isDisplayed() &&
                galleryLink.isDisplayed();
    }
}
