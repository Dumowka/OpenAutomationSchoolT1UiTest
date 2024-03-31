package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class ContextMenuPage extends AbstractPage {

    private final SelenideElement box = $x("//div[@id='hot-spot']").as("Область, выделенная контуром");

    public ContextMenuPage() {
        super("Context Menu");
    }

    public ContextMenuPage rightClickOnBox() {
        box.contextClick();
        return this;
    }

    public String getAlertText() {
         return switchTo().alert().getText();
    }
}
