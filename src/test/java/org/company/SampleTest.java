package org.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.company.pages.BasePage;
import org.company.pages.HomePage;
import org.company.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
url=https://login.salesforce.com/
username=testuname@xyz.com
pwd=user@123
 */
public class SampleTest {
WebDriver driver;
    @Test(description = "Check RemeberMe - 3",enabled =false)
    public void CheckRememberMe() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        LoginPage loginPage = new LoginPage(driver);;
        loginPage.checkRememberMe();
        HomePage homePage = loginPage.loginToGeHomePage("testuname@xyz.com", "user@123");
        driver.manage().window().maximize();
        String actualTitle = homePage.getTitle(homePage);
        String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
        Assert.assertEquals(actualTitle,expectedTitle);
        //homePage.selectLogout();
        //WebElement userMenuBtn = driver.findElement(By.xpath("//div[@id='userNav']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userNav']")));
        //WebElement userMenuBtn = driver.findElement(By.xpath("//*[@id='userNav']"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='userNavLabel']")));
        //String path = "testUname testLa..."
                ////div[@class= 'menuButton menuButtonRounded menuButtonActivated']
        //WebElement userMenuBtn = driver.findElement(By.xpath("//span[@id='userNavLabel']"));

        //WebElement userMenuBtn = driver.findElement(By.xpath("//*[@class='menuButton menuButtonRounded menuButtonActivated']"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='menuButton menuButtonRounded menuButtonActivated']")));
        WebElement userMenuBtn = driver.findElement(By.xpath("//*[@id='userNav']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userNav']")));
        Select select = new Select(userMenuBtn);
        select.selectByVisibleText("Logout");
        String actualIdCard = loginPage.getIdCardText();
        String expectedIdCard = "testuname@xyz.com";
        Assert.assertEquals(actualIdCard,expectedIdCard);
        driver.close();
         }




    @Test(description = "Select UserMenu from DropDown",enabled = false)
    public void TC05_UserMenuDropDown() {
        // Launch and Login
        // Check for user menu for <username> drop down
        // Click on the user menu for <username> drop down

    }
    @Test(description = "Select My Profile Option from DropDown",enabled = false)
    public void TC06_MyProfileOptionFromUserMenu() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        LoginPage loginPage = new LoginPage(driver);;
        loginPage.checkRememberMe();
        HomePage homePage = loginPage.loginToGeHomePage("testuname@xyz.com", "user@123");
        driver.manage().window().maximize();
        String actualTitle = homePage.getTitle(homePage);
        String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
        Assert.assertEquals(actualTitle,expectedTitle);
        homePage.navigateToProfilePage();

        WebElement MyProfile = driver.findElement(By.xpath("//a[@title='My Profile']"));
        //Click on edit profile button to edit contact information
        //Click on About tab
        //Click on post link
        //Click on file link
        //Click on Add photo link
    }

    public void TC07_MySettingsFromUserMenu() {
//        Select user menu for <username > drop down[TC01]
//        Click "My Settings" option from user menu
//        Click on personal link and select Login History link.
//                Click on Display &Layout link
//        Click on Email link and click on my email settings link under that
//        Click on Calendar & Remainders
    }

}
