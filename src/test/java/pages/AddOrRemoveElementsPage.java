package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AddOrRemoveElementsPage extends AbstractPage {

    private final SelenideElement addElementButton = $x("//button[@onclick='addElement()']");
    private final ElementsCollection addedElementButtons = $$x("//button[@onclick='deleteElement()']");

    public AddOrRemoveElementsPage() {
        super("Add/Remove Elements");
    }

    public AddOrRemoveElementsPage clickOnAddElementButton() {
        int elementsCountBefore = addedElementButtons.size();
        addElementButton.click();
        return waitForAddedElementAppear(elementsCountBefore);
    }

    public AddOrRemoveElementsPage printAddedElementText() {
        System.out.println(addedElementButtons.last().getText());
        return this;
    }

    public AddOrRemoveElementsPage clickOnRandomAddedElement() {
        int elementsCountBefore = addedElementButtons.size();
        int index = ThreadLocalRandom.current().nextInt(elementsCountBefore);
        addedElementButtons.get(index).click();
        return waitForAddedElementDisappear(elementsCountBefore);
    }

    public AddOrRemoveElementsPage printAddedElementsCount() {
        System.out.println(addedElementButtons.size());
        return this;
    }

    public AddOrRemoveElementsPage printTextFromAllAddedElements() {
        addedElementButtons.asDynamicIterable().forEach(element -> System.out.println(element.getText()));
        return this;
    }

    private AddOrRemoveElementsPage waitForAddedElementAppear(int elementsCountBefore) {
        addedElementButtons.shouldBe(size(elementsCountBefore + 1));
        return this;
    }

    private AddOrRemoveElementsPage waitForAddedElementDisappear(int elementsCountBefore) {
        addedElementButtons.shouldBe(size(elementsCountBefore - 1));
        return this;
    }
}
