package tests;

import common.ConfigProperties;
import common.DriverConfiguration;
import org.junit.jupiter.api.*;
import pages.MainPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractTest {

    protected static final ConfigProperties config = ConfigProperties.getInstance();

    public static final boolean IS_CI_RUN = Objects.equals(config.getConfigParameter("IS_CI_RUN"), "true");

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
