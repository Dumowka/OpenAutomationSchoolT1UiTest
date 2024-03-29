package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends AbstractPage {
    private final SelenideElement checkboxesLink = $x("//a[@href='/checkboxes']").as("Ссылка на страницу 'Checkboxes'");
    private final SelenideElement dropdownLink = $x("//a[@href='/dropdown']").as("Ссылка на страницу 'Dropdown'");
    private final SelenideElement disappearingElementsLink = $x("//a[@href='/disappearing_elements']").as("Ссылка на страницу 'Disappearing Elements'");
    private final SelenideElement inputsLink = $x("//a[@href='/inputs']").as("Ссылка на страницу 'Inputs'");
    private final SelenideElement hoversLink = $x("//a[@href='/hovers']").as("Ссылка на страницу 'Hovers'");
    private final SelenideElement notificationMessagesLink = $x("//a[@href='/notification_message']").as("Ссылка на страницу 'Notification Message'");
    private final SelenideElement addRemoveElementsLink = $x("//a[@href='/add_remove_elements/']").as("Ссылка на страницу 'Add/Remove Elements'");
    private final SelenideElement statusCodesLink = $x("//a[@href='/status_codes']").as("Ссылка на страницу 'Status Codes'");

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
