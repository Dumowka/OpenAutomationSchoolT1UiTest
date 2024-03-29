package common;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;


public class DriverConfiguration {

    public void configureDriver(ConfigProperties config) {
        Configuration.timeout = 10_000;
        Configuration.baseUrl = config.getConfigParameter("BASE_URI");

        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = null;

        addListener(
                "AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true).enableLogs(LogType.BROWSER, Level.ALL).includeSelenideSteps(true)
        );
    }
}
