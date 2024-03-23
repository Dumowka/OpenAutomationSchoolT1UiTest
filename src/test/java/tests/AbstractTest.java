package tests;

import common.ConfigProperties;
import common.DriverConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractTest {

    protected static final ConfigProperties config = ConfigProperties.getInstance();
    protected MainPage mainPage;

    @BeforeAll
    void globalBeforeAll() {
        new DriverConfiguration().configureDriver(config);
        open("/");
        mainPage = new MainPage();
    }

    @AfterAll
    void cleanupTest() {
        closeWebDriver();
    }
}
