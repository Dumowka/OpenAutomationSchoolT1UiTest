package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AddOrRemoveElementsPage;

import java.util.stream.IntStream;

@DisplayName("Страница Add/Remove Elements")
class AddOrRemoveElementsTest extends CommonTest {

    @Test
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Add/Remove Elements.
            Нажать на кнопку Add Element 5 раз.
            С каждым нажатием выводить в консоль текст появившегося элемента.
            Нажать на разные кнопки Delete три раза.
            Выводить в консоль оставшееся количество кнопок Delete и их тексты.
            """)
    void addOrRemoveElementsTest() {
        AddOrRemoveElementsPage addOrRemoveElementsPage = mainPage.clickOnAddRemoveElementsLink();
        IntStream.range(0, 5).forEach(i -> addOrRemoveElementsPage.clickOnAddElementButton().printAddedElementText());
        IntStream.range(0, 3).forEach(i -> addOrRemoveElementsPage.clickOnRandomAddedElement());
        addOrRemoveElementsPage.printAddedElementsCount().printTextFromAllAddedElements();
    }
}
