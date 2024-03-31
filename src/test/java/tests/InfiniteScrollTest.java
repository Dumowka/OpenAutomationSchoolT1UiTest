package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.InfiniteScrollPage;

@DisplayName("Страница Infinite Scroll")
class InfiniteScrollTest extends AbstractTest {

    @Test
    @DisplayName("Скроллинг до определенного текста")
    @Description("""
             Перейти на страницу Infinite Scroll.
             Проскролить страницу до текста «Eius», проверить, что текст в поле зрения.
            """)
    void infiniteScrollTest() {
        InfiniteScrollPage infiniteScrollPage = mainPage.clickOnInfiniteScrollLink();
        infiniteScrollPage.scrollToElementWithText("Eius");
    }
}
