package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;

@DisplayName("Страница Checkboxes")
class CheckboxesTest extends CommonTest {

    @Test
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Checkboxes.
            Выделить первый чекбокс,
            снять выделение со второго чекбокса.
            Вывести в консоль состояние атрибута checked для каждого чекбокса.
            """)
    void checkboxesTest() {
        CheckboxesPage checkboxesPage = mainPage.clickOnCheckboxesLink();
        checkboxesPage
                .clickOnFirstCheckboxes()
                .clickOnSecondCheckboxes()
                .printCheckedAttributeFromAllCheckboxes();
    }
}
