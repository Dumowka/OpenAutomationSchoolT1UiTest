package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$$x;

public class CheckboxesPage extends AbstractPage {

    private final ElementsCollection checkboxesInput = $$x("//input[@type='checkbox']").as("Чекбоксы");

    public CheckboxesPage() {
        super("Checkboxes");
    }

    public CheckboxesPage clickOnFirstCheckbox() {
        checkboxesInput.get(0).click();
        return this;
    }

    public CheckboxesPage clickOnSecondCheckbox() {
        checkboxesInput.get(1).click();
        return this;
    }

    public boolean getFirstCheckboxCheckedValue() {
        return checkboxesInput.get(0).getAttribute("checked") != null;
    }

    public boolean getSecondCheckboxCheckedValue() {
        return checkboxesInput.get(1).getAttribute("checked") != null;
    }

    public CheckboxesPage checkThatFirstCheckboxCheckedHasChanged(boolean isChecked) {
        return checkThatCheckboxCheckedHasChanged(checkboxesInput.get(0), isChecked);
    }

    public CheckboxesPage checkThatSecondCheckboxCheckedHasChanged(boolean isChecked) {
        return checkThatCheckboxCheckedHasChanged(checkboxesInput.get(1), isChecked);
    }

    private CheckboxesPage checkThatCheckboxCheckedHasChanged(SelenideElement checkbox, boolean isChecked) {
        checkbox.shouldHave(not(attribute("checked", isChecked ? "true" : "")));
        return this;
    }
}
