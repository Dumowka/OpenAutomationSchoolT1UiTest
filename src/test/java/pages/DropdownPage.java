package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage extends AbstractPage {

    private final SelenideElement dropdownSelect = $x("//select[@id='dropdown']").as("Выпадающий список");
    private final SelenideElement firstOption = $x("//option[@value='1']").as("Первый элемент выпадающего списка");
    private final SelenideElement secondOption = $x("//option[@value='2']").as("Второй элемент выпадающего списка");

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

    public DropdownPage checkFirstOptionSelectedStatus(boolean shouldBeSelected) {
        firstOption.shouldBe(attribute("selected", shouldBeSelected? "true" : ""));
        return this;
    }

    public DropdownPage checkSecondOptionSelectedStatus(boolean shouldBeSelected) {
        secondOption.shouldBe(attribute("selected", shouldBeSelected? "true" : ""));
        return this;
    }
}
