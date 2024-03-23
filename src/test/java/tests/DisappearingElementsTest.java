package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DisappearingElementsPage;

import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.refresh;

@DisplayName("Страница Disappearing Elements")
class DisappearingElementsTest extends CommonTest {

    @Test
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Disappearing Elements.
            Добиться отображения 5 элементов, максимум за 10 попыток, если нет, провалить тест с ошибкой.
            """)
    void disappearingElementsTest() {
        DisappearingElementsPage disappearingElementsPage = mainPage.clickOnDisappearingElementsLink();
        int tries = 10;
        boolean isAllVisible = false;
        for (int i = 0; i < tries; tries--) {
            if (disappearingElementsPage.checkThatAllLinksIsAppear()) {
                isAllVisible = true;
                break;
            }
            refresh();
        }

        if (!isAllVisible) {
            throw new AssertionError("Все элементы не отобразились на 10 попыток.");
        }
    }
}
