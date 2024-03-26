package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InputsPage extends AbstractPage {

    private final SelenideElement numberInput = $x("//input[@type='number']");

    public InputsPage() {
        super("Inputs");
    }

    public InputsPage setValueInNumberInput(double value) {
        numberInput.sendKeys(String.valueOf(value));
        return this;
    }

    public InputsPage printValueFromNumberInput() {
        System.out.println(numberInput.getValue());
        return this;
    }
}
