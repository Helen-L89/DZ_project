package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;



public class WebDriverFactory {
    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        if ("chrome".equalsIgnoreCase(browser)) {
            // Для локального запуска Chrome
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            // Для локального запуска Firefox
            driver = new FirefoxDriver();
        } else {
            // Если используется удаленный запуск через Selenium Grid или BrowserStack
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } catch (Exception e) {
                throw new RuntimeException("Не удалось запустить удаленный WebDriver", e);
            }
        }
        return driver;
    }

}
