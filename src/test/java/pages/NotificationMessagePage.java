package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$x;

public class NotificationMessagePage extends AbstractPage {

    private final SelenideElement clickHereLink = $x("//a[@href='/notification_message']").as("Click here (ссылка)");
    private final SelenideElement notificationMessageBlock = $x("//div[@id='flash']").as("Всплывающее окно");
    private final SelenideElement closeNotificationMessageLink = $x("//a[@class='close']").as("Закрыть всплывающее окно (ссылка)");

    public NotificationMessagePage() {
        super("Notification Message");
    }

    public NotificationMessagePage clickOnClickHereLink() {
        clickHereLink.click();
        return this;
    }

    public String getNotificationMessage() {
        return notificationMessageBlock.getText();
    }

    public NotificationMessagePage closeNotificationMessage() {
        closeNotificationMessageLink.click();
        notificationMessageBlock.shouldBe(disappear);
        return this;
    }
}
