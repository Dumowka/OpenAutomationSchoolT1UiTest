package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElementsPage extends AbstractPage {

    private final SelenideElement homeLink = $x("//a[@href='/']").as("Home (кнопка)");
    private final SelenideElement aboutLink = $x("//a[@href='/about/']").as("About (кнопка)");
    private final SelenideElement contactUsLink = $x("//a[@href='/contact-us/']").as("Contact Us (кнопка)");
    private final SelenideElement portfolioLink = $x("//a[@href='/portfolio/']").as("Portfolio (кнопка)");
    private final SelenideElement galleryLink = $x("//a[@href='/gallery/']").as("Gallery (кнопка)");

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
