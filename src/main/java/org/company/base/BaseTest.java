package org.company.base;

import org.company.pages.BasePage;
import org.company.utilities.CommonUtilities;
import org.company.utilities.CustomDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.company.utilities.Constants.IMPLICIT_WAIT;
import static org.company.utilities.Constants.PAGE_LOAD_TIMEOUT;
import static org.company.utilities.TestUtils.takeScreenShot;

public class BaseTest {
    public CommonUtilities prop;
    public BasePage basePage;
    protected WebDriver driver;
    CustomDriverFactory customBrowser;

    public BaseTest() {
        prop = new CommonUtilities();
    }

    protected void initialization(final String browser) {
        driver = CustomDriverFactory.getBrowserDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT,
                TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,
                TimeUnit.SECONDS);
        driver.get(prop.getApplicationProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        try {
            takeScreenShot(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    protected void pause(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
