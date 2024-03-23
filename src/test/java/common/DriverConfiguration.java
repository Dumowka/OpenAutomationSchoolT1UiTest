package common;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfiguration {

    public void configureDriver(ConfigProperties config) {
        Configuration.timeout = 60_000;
        Configuration.baseUrl = config.getConfigParameter("BASE_URI");

        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = null;
    }
}
