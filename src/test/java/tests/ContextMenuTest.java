package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Страница Context menu")
class ContextMenuTest extends AbstractTest {

    @Test
    @DisplayName("Проверка контекстного меню")
    @Description("""
             Перейти на страницу Context menu.
             Нажать правой кнопкой мыши на отмеченной области и проверить, что JS Alert имеет ожидаемый текст.
            """)
    void contextMenuTest() {
        ContextMenuPage contextMenuPage = mainPage.clickOnContextMenuLink();
        assertThat(contextMenuPage.rightClickOnBox().getAlertText()).isEqualTo("You selected a context menu");
    }
}
