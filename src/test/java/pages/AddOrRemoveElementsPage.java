package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AddOrRemoveElementsPage extends AbstractPage {

    private final SelenideElement addElementButton = $x("//button[@onclick='addElement()']").as("Добавить (кнопка)");
    private final ElementsCollection addedElementButtons = $$x("//button[@onclick='deleteElement()']").as("Добавленный элемент (кнопка)");

    public AddOrRemoveElementsPage() {
        super("Add/Remove Elements");
    }

    public AddOrRemoveElementsPage clickOnAddElementButton() {
        addElementButton.click();
        return this;
    }

    public int getAddedElementsCount() {
        return addedElementButtons.size();
    }

    public AddOrRemoveElementsPage clickOnLastAddedElement() {
        if (addedElementButtons.size() != 0) {
            addedElementButtons.last().click();
        } else {
            System.out.println("Элементов больше нет");
        }
        return this;
    }

    public AddOrRemoveElementsPage printAddedElementsCount() {
        System.out.println(addedElementButtons.size());
        return this;
    }

    public AddOrRemoveElementsPage printTextFromAllAddedElements() {
        addedElementButtons.asDynamicIterable().forEach(element -> System.out.println(element.getText()));
        return this;
    }
}
