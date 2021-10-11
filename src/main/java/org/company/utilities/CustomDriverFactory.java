package org.company.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.company.base.BaseTest;
import org.company.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CustomDriverFactory {

    public static  WebDriver getBrowserDriver(final String browserName) {
        WebDriver driver = null;
       // String browser = System.getProperty("browser");
        String browser =  browserName;
        if(null == browser)
            browser = "chrome";

        switch (browser) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }
}


