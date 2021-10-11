package org.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BaseHomePage extends BasePage {

    public BaseHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='userNav']")
    WebElement userMenuBtn;

    @FindBy(xpath="//*[@id='userNav-menuItems']")
    WebElement userMenuDropDownItems;


    @FindBy(xpath="//a[@title='My Profile']")
    WebElement myProfile;

    @FindBy(id="name")
    WebElement firstName;

    public void clickOnUserMenu()  {
        clickCheckBox(userMenuBtn);
    }

    public ProfilePage navigateToProfilePage()  {
        selectByVisibleText(userMenuBtn, "My Profile");
        // check / wait
        return new ProfilePage(driver);
    }

    public LogoutPage navigateToLogoutPage()  {
        selectByVisibleText(userMenuBtn, "logout");
        // check / wait
        return new LogoutPage(driver);
    }

    public SettingsPage navigateToSettingsPage()  {
        selectByVisibleText(userMenuBtn, "logout");
        //clickCheckBox(userMenuBtn);
        return new SettingsPage(driver);
    }

    public String  getUserMenuDropDwonItems(){
        clickCheckBox(userMenuBtn);
        Select select = new Select(userMenuBtn);
        wait.until(ExpectedConditions.visibilityOf(userMenuDropDownItems));
        String dropdownverify=userMenuDropDownItems.getText();
        return dropdownverify;
    }

    public void selectSwitchToLightningExperience()  {
        selectByVisibleText(userMenuBtn, "Switch to Lightning Experience");
    }

    public void selectLogout()  {

    }

}
