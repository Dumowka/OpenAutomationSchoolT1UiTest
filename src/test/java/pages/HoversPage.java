package pages;

import com.codeborne.selenide.WebElementsCondition;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

public class HoversPage extends AbstractPage {

    private final String imagesXpath = "//div[@class='figure']/img";
    private final String appearedTextXpath = "//div[@class='figcaption']";

    public HoversPage() {
        super("Hovers");
    }

    public HoversPage hoverToFirstImage() {
        $$x(imagesXpath).get(0).hover();
        return this;
    }

    public HoversPage hoverToSecondImage() {
        $$x(imagesXpath).get(1).hover();
        return this;
    }

    public HoversPage hoverToThirdImage() {
        $$x(imagesXpath).get(2).hover();
        return this;
    }

    public HoversPage printAppearedText() {
        System.out.println($$x(appearedTextXpath).filter(visible).shouldBe(size(1)).get(0).getText());
        return this;
    }
}
