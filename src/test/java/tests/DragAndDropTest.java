package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import pages.DragAndDropPage;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Страница Drag and Drop")
class DragAndDropTest extends AbstractTest {

    @Test
    @DisplayName("Перетаскивание элементов")
    @Description("""
            Перейти на страницу Drag and Drop.
            Перетащить элемент A на элемент B.
            Задача на 10 баллов – сделать это, не прибегая к методу DragAndDrop();
            Проверить, что элементы поменялись местами
            """)
    void dragAndDropTest() {
        DragAndDropPage dragAndDropPage = mainPage.clickOnDragAndDropLink();

        Point blockALocationBefore = dragAndDropPage.getBlockALocation();
        Point blockBLocationBefore = dragAndDropPage.getBlockBLocation();

        dragAndDropPage.moveElementAToElementB();

        assertThat(blockALocationBefore).usingRecursiveComparison().isEqualTo(dragAndDropPage.getBlockBLocation());
        assertThat(blockBLocationBefore).usingRecursiveComparison().isEqualTo(dragAndDropPage.getBlockALocation());
    }
}
