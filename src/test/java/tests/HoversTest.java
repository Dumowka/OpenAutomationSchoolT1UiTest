package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HoversPage;

@DisplayName("Страница Hovers")
class HoversTest extends AbstractTest {

    @Test
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Hovers.
            Навести курсор на каждую картинку.
            Вывести в консоль текст, который появляется при наведении.
            """)
    void hoversTest() {
        HoversPage hoversPage = mainPage.clickOnHoversLink();
        hoversPage.hoverToFirstImage().printAppearedText().hoverToSecondImage().printAppearedText().hoverToThirdImage().printAppearedText();
    }
}
