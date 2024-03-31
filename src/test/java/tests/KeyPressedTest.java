package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.KeyPressesPage;

import java.util.List;

@DisplayName("Страница Key Presses")
class KeyPressedTest extends AbstractTest {

    @Test
    @DisplayName("Нажатие клавиш")
    @Description("""
              Перейти на страницу Key Presses.
              Нажать по 10 латинских символов, клавиши Enter, Ctrl, Alt, Tab.
              Проверить, что после нажатия отображается всплывающий текст снизу, соответствующий конкретной клавише.
            """)
    void keyPressedTest() {
        KeyPressesPage keyPressesPage = mainPage.clickOnKeyPressesLink();

        List<String> characters = List.of("A", "B","C","D","E","F","G","X","Y", "Z");
        List<Keys> keys = List.of(Keys.ENTER, Keys.CONTROL, Keys.ALT, Keys.TAB);

        characters.forEach(character -> keyPressesPage.sendKeys(character).checkThatResultContainsKeyPressedName(character));
        keys.forEach(key -> keyPressesPage.sendKeys(key).checkThatResultContainsKeyPressedName(key.name()));
    }
}
