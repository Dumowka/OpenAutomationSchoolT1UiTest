package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends AbstractPage {
    private final String checkboxesLinkXpath = "//a[@href='/checkboxes']";
    private final String dropdownLinkXpath = "//a[@href='/dropdown']";
    private final String disappearingElementsLinkXpath = "//a[@href='/disappearing_elements']";
    private final String inputsLinkXpath = "//a[@href='/inputs']";
    private final String hoversLinkXpath = "//a[@href='/hovers']";
    private final String notificationMessagesLinkXpath = "//a[@href='/notification_message']";
    private final String addRemoveElementsLinkXpath = "//a[@href='/add_remove_elements/']";
    private final String statusCodesLinkXpath = "//a[@href='/status_codes']";

    public MainPage() {
        super("Welcome to the-internet");
    }

    public CheckboxesPage clickOnCheckboxesLink() {
        $x(checkboxesLinkXpath).click();
        return new CheckboxesPage();
    }

    public DropdownPage clickOnDropdownLink() {
        $x(dropdownLinkXpath).click();
        return new DropdownPage();
    }

    public DisappearingElementsPage clickOnDisappearingElementsLink() {
        $x(disappearingElementsLinkXpath).click();
        return new DisappearingElementsPage();
    }

    public InputsPage clickOnInputsLink() {
        $x(inputsLinkXpath).click();
        return new InputsPage();
    }

    public HoversPage clickOnHoversLink() {
        $x(hoversLinkXpath).click();
        return new HoversPage();
    }

    public NotificationMessagePage clickOnNotificationMessagesLink() {
        $x(notificationMessagesLinkXpath).click();
        return new NotificationMessagePage();
    }

    public AddOrRemoveElementsPage clickOnAddRemoveElementsLink() {
        $x(addRemoveElementsLinkXpath).click();
        return new AddOrRemoveElementsPage();
    }

    public StatusCodesPage clickOnStatusCodesLink() {
        $x(statusCodesLinkXpath).click();
        return new StatusCodesPage();
    }
}
