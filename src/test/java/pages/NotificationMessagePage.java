package pages;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$x;

public class NotificationMessagePage extends AbstractPage {

    private final String clickHereLinkXpath = "//a[@href='/notification_message']";
    private final String notificationMessageBlockXpath = "//div[@id='flash']";
    private final String closeNotificationMessageLinkXpath = "//a[@class='close']";

    public NotificationMessagePage() {
        super("Notification Message");
    }

    public NotificationMessagePage clickOnClickHereLink() {
        $x(clickHereLinkXpath).click();
        return this;
    }

    public String getNotificationMessage() {
        return $x(notificationMessageBlockXpath).getText();
    }

    public NotificationMessagePage closeNotificationMessage() {
        $x(closeNotificationMessageLinkXpath).click();
        $x(notificationMessageBlockXpath).shouldBe(disappear);
        return this;
    }
}
