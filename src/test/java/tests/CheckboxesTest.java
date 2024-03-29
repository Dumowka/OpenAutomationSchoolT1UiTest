package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CheckboxesPage;

@DisplayName("Страница Checkboxes")
class CheckboxesTest extends AbstractTest {

    private CheckboxesPage checkboxesPage;

    @Test
    @Order(1)
    @DisplayName("Переход на страницу Checkboxes")
    void goToCheckboxesPageTest() {
        checkboxesPage = mainPage.clickOnCheckboxesLink();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @Order(2)
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Checkboxes.
            Выделить первый чекбокс,
            снять выделение со второго чекбокса.
            Вывести в консоль состояние атрибута checked для каждого чекбокса.
            """)
    void checkboxesTest(Boolean firstThenSecond) {
        boolean firstCheckboxCheckedValueBefore = checkboxesPage.getFirstCheckboxCheckedValue();
        boolean secondCheckboxCheckedValueBefore = checkboxesPage.getSecondCheckboxCheckedValue();

        if (firstThenSecond) {
            checkboxesPage
                    .clickOnFirstCheckbox()
                    .checkThatFirstCheckboxCheckedHasChanged(firstCheckboxCheckedValueBefore)
                    .clickOnSecondCheckbox()
                    .checkThatSecondCheckboxCheckedHasChanged(secondCheckboxCheckedValueBefore);
        } else {
            checkboxesPage
                    .clickOnSecondCheckbox()
                    .checkThatSecondCheckboxCheckedHasChanged(secondCheckboxCheckedValueBefore)
                    .clickOnFirstCheckbox()
                    .checkThatFirstCheckboxCheckedHasChanged(firstCheckboxCheckedValueBefore);
        }

    }
}
