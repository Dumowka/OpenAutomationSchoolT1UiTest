package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HoversPage;

import java.util.function.Supplier;
import java.util.stream.Stream;

@DisplayName("Страница Hovers")
class HoversTest extends AbstractTest {

    private HoversPage hoversPage;

    @Test
    @Order(1)
    @DisplayName("Переход на страницу Hovers")
    void goToHoversPageTest() {
        hoversPage = mainPage.clickOnHoversLink();
    }

    private Stream<Arguments> hoverParams() {
        return Stream.of(
                Arguments.of("на первую картинку", (Supplier<HoversPage>) hoversPage::hoverToFirstImage, "name: user1\nView profile"),
                Arguments.of("на вторую картинку", (Supplier<HoversPage>) hoversPage::hoverToSecondImage, "name: user2\nView profile"),
                Arguments.of("на третью картинку", (Supplier<HoversPage>) hoversPage::hoverToThirdImage, "name: user3\nView profile")
        );
    }

    @ParameterizedTest(name = "{displayName} {0}")
    @MethodSource("hoverParams")
    @Order(2)
    @DisplayName("Наведение курсора")
    @Description("""
            Перейти на страницу Hovers.
            Навести курсор на каждую картинку.
            Вывести в консоль текст, который появляется при наведении.
            """)
    void hoversTest(String name, Supplier<HoversPage> hoverToImage, String expectedTest) {
        hoverToImage.get().checkAppearedText(expectedTest);
    }
}
