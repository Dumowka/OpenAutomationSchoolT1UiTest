package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.NotificationMessagePage;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Страница Notification Message")
class NotificationMessageTest extends AbstractTest {

    private NotificationMessagePage notificationMessagePage;

    @Test
    @Order(1)
    @DisplayName("Переход на страницу Notification Message")
    void goToNotificationMessagePageTest() {
        notificationMessagePage = mainPage.clickOnNotificationMessagesLink();
    }

    @RepeatedTest(value = 5)
    @Order(2)
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Notification Message.
            Кликать до тех пор, пока не покажется уведомление Action successful.
            После каждого неудачного клика закрывать всплывающее уведомление.
            """)
    void notificationMessageTest() {
        notificationMessagePage.closeNotificationMessage().clickOnClickHereLink();
        assertThat(notificationMessagePage.getNotificationMessage().contains("Action successful")).isTrue();
    }
}
