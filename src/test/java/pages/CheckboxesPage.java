package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckboxesPage extends AbstractPage {

    private final String checkboxesInputXpath = "//input[@type='checkbox']";

    public CheckboxesPage() {
        super("Checkboxes");
    }

    public CheckboxesPage clickOnFirstCheckboxes() {
        $$x(checkboxesInputXpath).get(0).click();
        return this;
    }

    public CheckboxesPage clickOnSecondCheckboxes() {
        $$x(checkboxesInputXpath).get(1).click();
        return this;
    }

    public CheckboxesPage printCheckedAttributeFromAllCheckboxes() {
        $$x(checkboxesInputXpath).asDynamicIterable().forEach(checkbox -> System.out.println(checkbox.getAttribute("checked")));
        return this;
    }
}
