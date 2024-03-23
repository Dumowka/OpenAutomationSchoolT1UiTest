package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.InputsPage;

import java.util.concurrent.ThreadLocalRandom;

@DisplayName("Страница Inputs")
class InputsTest extends CommonTest {

    @Test
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Inputs. 
            Ввести любое случайное число от 1 до 10 000. 
            Вывести в консоль значение элемента Input.
            """)
    void inputsTest() {
        InputsPage inputsPage = mainPage.clickOnInputsLink();
        inputsPage.setValueInNumberInput(ThreadLocalRandom.current().nextDouble(1, 10000)).printValueFromNumberInput();
    }
}
