package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class InputsPage extends AbstractPage {

    private final String numberInputXpath = "//input[@type='number']";

    public InputsPage() {
        super("Inputs");
    }

    public InputsPage setValueInNumberInput(double value) {
        $x(numberInputXpath).setValue(String.valueOf(value));
        return this;
    }

    public InputsPage printValueFromNumberInput() {
        System.out.println($x(numberInputXpath).getValue());
        return this;
    }
}
