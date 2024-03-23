package tests;

import common.ConfigProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommonTest {

    protected static final ConfigProperties config = ConfigProperties.getInstance();
    protected MainPage mainPage;

    @BeforeAll
    void globalBeforeAll() {
        open(config.getConfigParameter("BASE_URI"));
        mainPage = new MainPage();
    }
}
