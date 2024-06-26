package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

@DisplayName("Страница Dropdown")
class DropdownTest extends AbstractTest {

    @Test
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Dropdown.
            Выбрать первую опцию,
            вывести в консоль текущий текст элемента dropdown,
            выбрать вторую опцию,
            вывести в консоль текущий текст элемента dropdown.
            """)
    void dropdownTest() {
        DropdownPage dropdownPage = mainPage.clickOnDropdownLink();
        dropdownPage
                .clickOnDropdownSelect()
                .selectFirstOption()
                .checkFirstOptionSelectedStatus(true)
                .printDropdownSelectText()
                .selectSecondOption()
                .checkFirstOptionSelectedStatus(false)
                .checkSecondOptionSelectedStatus(true)
                .printDropdownSelectText();
    }
}
