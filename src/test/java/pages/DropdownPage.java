package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage extends AbstractPage {

    private final SelenideElement dropdownSelect = $x("//select[@id='dropdown']");
    private final SelenideElement firstOption = $x("//option[@value='1']");
    private final SelenideElement secondOption = $x("//option[@value='2']");

    public DropdownPage() {
        super("Dropdown List");
    }

    public DropdownPage clickOnDropdownSelect() {
        dropdownSelect.click();
        return this;
    }

    public DropdownPage printDropdownSelectText() {
        System.out.println(dropdownSelect.getText());
        return this;
    }

    public DropdownPage selectFirstOption() {
        firstOption.click();
        return this;
    }

    public DropdownPage selectSecondOption() {
        secondOption.click();
        return this;
    }

}
