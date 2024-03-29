package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.StatusCodePage;
import pages.StatusCodesPage;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.back;

@DisplayName("Страница Status Codes")
class StatusCodesTest extends AbstractTest {

    private StatusCodesPage statusCodesPage;

    @BeforeAll
    void beforeAll() {
        statusCodesPage = mainPage.clickOnStatusCodesLink();
    }

    private Stream<Arguments> statusCodesParams() {
        return Stream.of(
                Arguments.of(
                        "200",
                        (Supplier<StatusCodePage>) statusCodesPage::clickOnOkStatusCodeLink,
                        "This page returned a 200 status code."
                ),
                Arguments.of(
                        "301",
                        (Supplier<StatusCodePage>) statusCodesPage::clickOnMovedPermanentlyStatusCodeLink,
                        "This page returned a 301 status code."
                ),
                Arguments.of(
                        "404",
                        (Supplier<StatusCodePage>) statusCodesPage::clickOnNotFoundStatusCodeLink,
                        "This page returned a 404 status code."
                ),
                Arguments.of(
                        "500",
                        (Supplier<StatusCodePage>) statusCodesPage::clickOnInternalServerErrorStatusCodeLink,
                        "This page returned a 500 status code."
                )
        );
    }

    @ParameterizedTest(name = "{displayName} {0}")
    @MethodSource("statusCodesParams")
    @DisplayName("Проверка перехода на страницу статус кода")
    @Description("""
            Перейти на страницу Status Codes.
            Кликнуть на каждый статус в новом тестовом методе,
            вывести на экран текст после перехода на страницу статуса.
            """)
    void statusCodesTest(String name, Supplier<StatusCodePage> method, String expectedTextOnPage) {
        method.get().checkThatCorrectPageIsOpened(expectedTextOnPage).printTextFromPage();
        back();
    }
}
