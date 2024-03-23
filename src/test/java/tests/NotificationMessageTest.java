package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.NotificationMessagePage;

@DisplayName("Страница Notification Message")
class NotificationMessageTest extends AbstractTest {

    @Test
    @DisplayName("Тест")
    @Description("""
            Перейти на страницу Notification Message.
            Кликать до тех пор, пока не покажется уведомление Action successful.
            После каждого неудачного клика закрывать всплывающее уведомление.
            """)
    void notificationMessageTest() {
        NotificationMessagePage notificationMessagePage = mainPage.clickOnNotificationMessagesLink();
        do {
            notificationMessagePage.closeNotificationMessage().clickOnClickHereLink();
        } while (!notificationMessagePage.getNotificationMessage().contains("Action successful"));
    }
}
