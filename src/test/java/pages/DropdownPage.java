package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage extends AbstractPage {

    private final String dropdownSelectXpath = "//select[@id='dropdown']";
    private final String firstOptionXpath = "//option[@value='1']";
    private final String secondOptionXpath = "//option[@value='2']";

    public DropdownPage() {
        super("Dropdown List");
    }

    public DropdownPage clickOnDropdownSelect() {
        $x(dropdownSelectXpath).click();
        return this;
    }

    public DropdownPage printDropdownSelectText() {
        System.out.println($x(dropdownSelectXpath).getText());
        return this;
    }

    public DropdownPage selectFirstOption() {
        $x(firstOptionXpath).click();
        return this;
    }

    public DropdownPage selectSecondOption() {
        $x(secondOptionXpath).click();
        return this;
    }

}
