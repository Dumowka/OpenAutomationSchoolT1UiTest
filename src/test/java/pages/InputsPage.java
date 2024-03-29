package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InputsPage extends AbstractPage {

    private final SelenideElement numberInput = $x("//input[@type='number']").as("Поле ввода");

    public InputsPage() {
        super("Inputs");
    }

    public InputsPage setValueInNumberInput(String value) {
        numberInput.sendKeys(value);
        return this;
    }

    public InputsPage clearNumberInput() {
        numberInput.clear();
        return this;
    }

    public String getNumberInputValue() {
        return numberInput.getValue();
    }
}
