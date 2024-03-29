package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

public class HoversPage extends AbstractPage {

    private final ElementsCollection images = $$x("//div[@class='figure']/img").as("Картинка");
    private final ElementsCollection appearedText = $$x("//div[@class='figcaption']").as("Появляющийся текст");

    public HoversPage() {
        super("Hovers");
    }

    public HoversPage hoverToFirstImage() {
        images.get(0).hover();
        return this;
    }

    public HoversPage hoverToSecondImage() {
        images.get(1).hover();
        return this;
    }

    public HoversPage hoverToThirdImage() {
        images.get(2).hover();
        return this;
    }

    public HoversPage printAppearedText() {
        System.out.println(appearedText.filter(visible).shouldBe(size(1)).get(0).getText());
        return this;
    }

    public HoversPage checkAppearedText(String expectedText) {
        appearedText.filter(visible).shouldBe(size(1)).get(0).shouldHave(text(expectedText));
        return this;
    }
}
