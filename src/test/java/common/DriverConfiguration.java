package common;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static tests.AbstractTest.IS_CI_RUN;


public class DriverConfiguration {

    public void configureDriver(ConfigProperties config) {
        Configuration.timeout = 10_000;
        Configuration.baseUrl = config.getConfigParameter("BASE_URI");

        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = null;

        if (IS_CI_RUN) {
            Configuration.remote = config.getConfigParameter("REMOTE_UTL");
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            selenoidOptions.put("enableLog", true);
            selenoidOptions.put("sessionTimeout", "15m");
            Configuration.browserCapabilities.setCapability("selenoid:options", selenoidOptions);
        }

        addListener(
                "AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true).enableLogs(LogType.BROWSER, Level.ALL).includeSelenideSteps(true)
        );
    }
}
