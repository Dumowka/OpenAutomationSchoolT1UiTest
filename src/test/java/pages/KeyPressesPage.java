package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class KeyPressesPage extends AbstractPage {

    private final SelenideElement resultField = $x("//p[@id='result']").as("You entered: (текст)");

    protected final Actions action = new Actions(getWebDriver());

    public KeyPressesPage() {
        super("Key Presses");
    }

    public KeyPressesPage sendKeys(CharSequence charSequence) {
        action.sendKeys(charSequence).perform();
        return this;
    }

    public KeyPressesPage checkThatResultContainsKeyPressedName(String expectedKeyPressedName) {
        resultField.shouldHave(text("You entered: %s".formatted(expectedKeyPressedName)));
        return this;
    }
}
