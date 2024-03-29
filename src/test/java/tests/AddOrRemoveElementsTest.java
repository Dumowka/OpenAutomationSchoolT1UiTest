package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.modelmapper.internal.Pair;
import pages.AddOrRemoveElementsPage;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.refresh;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Страница Add/Remove Elements")
class AddOrRemoveElementsTest extends AbstractTest {

    private AddOrRemoveElementsPage addOrRemoveElementsPage;

    @Test
    @Order(1)
    @DisplayName("Переход на страницу Add/Remove Elements")
    void goToAddOrRemoveElementsPageTest() {
        addOrRemoveElementsPage = mainPage.clickOnAddRemoveElementsLink();
    }

    @TestFactory
    @Order(2)
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Add/Remove Elements.
            Нажать на кнопку Add Element 5 раз.
            С каждым нажатием выводить в консоль текст появившегося элемента.
            Нажать на разные кнопки Delete три раза.
            Выводить в консоль оставшееся количество кнопок Delete и их тексты.
            """)
    List<DynamicTest> addOrRemoveElementsTest() {
        List<Pair<Integer, Integer>> pairs = List.of(
                Pair.of(2,1),
                Pair.of(5,2),
                Pair.of(1,3)
        );
        addOrRemoveElementsPage.printAddedElementsCount().printTextFromAllAddedElements();
        return pairs.stream().map(pair -> DynamicTest.dynamicTest(
                "Добавление и удаление элементов в соотношении %s:%s".formatted(pair.getLeft(), pair.getRight()),
                () -> {
                    refresh();
                    AtomicInteger expectedAddedElementsCount = new AtomicInteger();
                    IntStream.range(0, pair.getLeft()).forEach(i -> {
                        addOrRemoveElementsPage.clickOnAddElementButton();
                        expectedAddedElementsCount.getAndIncrement();
                        assertThat(addOrRemoveElementsPage.getAddedElementsCount()).isEqualTo(expectedAddedElementsCount.get());
                    });
                    IntStream.range(0, pair.getRight()).forEach(i -> {
                        addOrRemoveElementsPage.clickOnLastAddedElement();
                        expectedAddedElementsCount.getAndDecrement();
                        assertThat(addOrRemoveElementsPage.getAddedElementsCount()).isEqualTo(expectedAddedElementsCount.get());
                    });
                }
        )).collect(Collectors.toList());
    }

//    @Test
//    @DisplayName("Тест")
//    @Description("""
//            Перейти на страницу Add/Remove Elements.
//            Нажать на кнопку Add Element 5 раз.
//            С каждым нажатием выводить в консоль текст появившегося элемента.
//            Нажать на разные кнопки Delete три раза.
//            Выводить в консоль оставшееся количество кнопок Delete и их тексты.
//            """)
//    void addOrRemoveElementsTest2() {
//        IntStream.range(0, 5).forEach(i -> addOrRemoveElementsPage.clickOnAddElementButton().printAddedElementText());
//        IntStream.range(0, 3).forEach(i -> addOrRemoveElementsPage.clickOnRandomAddedElement());
//        addOrRemoveElementsPage.printAddedElementsCount().printTextFromAllAddedElements();
//    }
}
