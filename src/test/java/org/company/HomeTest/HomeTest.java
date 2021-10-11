package org.company.HomeTest;

import org.company.base.BaseTest;
import org.company.pages.BasePage;
import org.company.pages.HomePage;
import org.company.pages.LoginPage;
import org.company.pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends BaseTest {

    public HomePage homePage;


    @Parameters({ "browserName"})
    @BeforeMethod
    public void setup(@Optional final String browser) throws IOException {
        initialization(browser);
        String usernameData = prop.getApplicationProperty("username");
        String pwdData = prop.getApplicationProperty("pwd");
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.loginToGeHomePage(usernameData,pwdData);
        pause(2000);
        driver.manage().window().maximize();
    }

    private void ensureHomePage() {
        String actualTitle = homePage.getTitle(homePage);
        String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(description = "Select UserMenu from DropDown",enabled = true)
    public void TC05_UserMenuDropDown() {
        // Launch and Login
        ensureHomePage();
        homePage.clickOnUserMenu();
        String dropDownVerify=driver.findElement(By.xpath("//div[@id='userNav-menuItems']")).getText();
        System.out.println(dropDownVerify);
        //String actualUserMenuItems= homePage.getUserMenuDropDwonItems();
        //String expectedUserMenuItems = "My ProfileMy SettingsDeveloper ConsoleSwitch to Lightning ExperienceLogout";
        //Assert.assertEquals(actualUserMenuItems,expectedUserMenuItems);
    }
    @Test(description = "Select My Profile Option from DropDown",enabled = false)
    public void TC06_MyProfileOptionFromUserMenu() {
        // Launch and Login
        ensureHomePage();
        ProfilePage profilePage = homePage.navigateToProfilePage();
        //click on myprofile

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
