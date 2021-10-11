package org.company.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomDriverFactory {

    public static WebDriver getBrowserDriver(final String browserName) {
        WebDriver driver = null;
        String browser = browserName;
        if (null == browser)
            browser = "chrome";

        switch (browser) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}


