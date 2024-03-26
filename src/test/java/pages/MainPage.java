package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends AbstractPage {
    private final SelenideElement checkboxesLink = $x("//a[@href='/checkboxes']");
    private final SelenideElement dropdownLink = $x("//a[@href='/dropdown']");
    private final SelenideElement disappearingElementsLink = $x("//a[@href='/disappearing_elements']");
    private final SelenideElement inputsLink = $x("//a[@href='/inputs']");
    private final SelenideElement hoversLink = $x("//a[@href='/hovers']");
    private final SelenideElement notificationMessagesLink = $x("//a[@href='/notification_message']");
    private final SelenideElement addRemoveElementsLink = $x("//a[@href='/add_remove_elements/']");
    private final SelenideElement statusCodesLink = $x("//a[@href='/status_codes']");

    public MainPage() {
        super("Welcome to the-internet");
    }

    public CheckboxesPage clickOnCheckboxesLink() {
        checkboxesLink.click();
        return new CheckboxesPage();
    }

    public DropdownPage clickOnDropdownLink() {
        dropdownLink.click();
        return new DropdownPage();
    }

    public DisappearingElementsPage clickOnDisappearingElementsLink() {
        disappearingElementsLink.click();
        return new DisappearingElementsPage();
    }

    public InputsPage clickOnInputsLink() {
        inputsLink.click();
        return new InputsPage();
    }

    public HoversPage clickOnHoversLink() {
        hoversLink.click();
        return new HoversPage();
    }

    public NotificationMessagePage clickOnNotificationMessagesLink() {
        notificationMessagesLink.click();
        return new NotificationMessagePage();
    }

    public AddOrRemoveElementsPage clickOnAddRemoveElementsLink() {
        addRemoveElementsLink.click();
        return new AddOrRemoveElementsPage();
    }

    public StatusCodesPage clickOnStatusCodesLink() {
        statusCodesLink.click();
        return new StatusCodesPage();
    }
}
