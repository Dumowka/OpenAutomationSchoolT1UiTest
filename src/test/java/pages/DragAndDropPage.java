package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DragAndDropPage extends AbstractPage {

    private final SelenideElement blockA = $x("//div[@id='column-a']").as("Элемент А");
    private final SelenideElement blockB = $x("//div[@id='column-b']").as("Элемент B");

    private final Actions action = new Actions(getWebDriver());

    public DragAndDropPage() {
        super("Drag and Drop");
    }

    public DragAndDropPage moveElementAToElementB() {
        action.clickAndHold(blockA).moveToElement(blockB).release().perform();
        return this;
    }

    public Point getBlockALocation() {
        return blockA.getLocation();
    }

    public Point getBlockBLocation() {
        return blockA.getLocation();
    }
}
