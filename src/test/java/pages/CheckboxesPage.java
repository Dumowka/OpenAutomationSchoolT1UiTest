package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class CheckboxesPage extends AbstractPage {

    private final ElementsCollection checkboxesInput = $$x("//input[@type='checkbox']");

    public CheckboxesPage() {
        super("Checkboxes");
    }

    public CheckboxesPage clickOnFirstCheckboxes() {
        checkboxesInput.get(0).click();
        return this;
    }

    public CheckboxesPage clickOnSecondCheckboxes() {
        checkboxesInput.get(1).click();
        return this;
    }

    public CheckboxesPage printCheckedAttributeFromAllCheckboxes() {
        checkboxesInput.asDynamicIterable().forEach(checkbox -> System.out.println(checkbox.getAttribute("checked")));
        return this;
    }
}
