package pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AddOrRemoveElementsPage extends AbstractPage {

    private final String addElementButtonXpath = "//button[@onclick='addElement()']";
    private final String addedElementButtonsXpath = "//button[@onclick='deleteElement()']";

    public AddOrRemoveElementsPage() {
        super("Add/Remove Elements");
    }

    public AddOrRemoveElementsPage clickOnAddElementButton() {
        int elementsCountBefore = $$x(addedElementButtonsXpath).size();
        $x(addElementButtonXpath).click();
        return waitForAddedElementAppear(elementsCountBefore);
    }

    public AddOrRemoveElementsPage printAddedElementText() {
        ElementsCollection addedElements = $$x(addedElementButtonsXpath);
        System.out.println(addedElements.get(addedElements.size() - 1).getText());
        return this;
    }

    public AddOrRemoveElementsPage clickOnRandomAddedElement() {
        ElementsCollection addedElements = $$x(addedElementButtonsXpath);
        int elementsCountBefore = $$x(addedElementButtonsXpath).size();
        int index = ThreadLocalRandom.current().nextInt(elementsCountBefore);
        addedElements.get(index).click();
        return waitForAddedElementDisappear(elementsCountBefore);
    }

    public AddOrRemoveElementsPage printAddedElementsCount() {
        System.out.println($$x(addedElementButtonsXpath).size());
        return this;
    }

    public AddOrRemoveElementsPage printTextFromAllAddedElements() {
        $$x(addedElementButtonsXpath).asDynamicIterable().forEach(element -> System.out.println(element.getText()));
        return this;
    }

    private AddOrRemoveElementsPage waitForAddedElementAppear(int elementsCountBefore) {
        $$x(addedElementButtonsXpath).shouldBe(size(elementsCountBefore + 1));
        return this;
    }

    private AddOrRemoveElementsPage waitForAddedElementDisappear(int elementsCountBefore) {
        $$x(addedElementButtonsXpath).shouldBe(size(elementsCountBefore - 1));
        return this;
    }
}
