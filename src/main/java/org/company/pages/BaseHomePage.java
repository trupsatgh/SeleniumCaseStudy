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
        selectByVisibleText(userMenuBtn, "Logout");
        // check / wait
        return new LogoutPage(driver);
    }

    public SettingsPage navigateToSettingsPage()  {
        selectByVisibleText(userMenuBtn, "My Settings");
        //clickCheckBox(userMenuBtn);
        return new SettingsPage(driver);
    }

    public String  getUserMenuDropDownItems(){
        clickCheckBox(userMenuBtn);
        Select select = new Select(userMenuBtn);
        wait.until(ExpectedConditions.visibilityOf(userMenuDropDownItems));
        return userMenuDropDownItems.getText();
    }

    /*public LightningPage navigateToSwitchToLightningExperience()  {
        selectByVisibleText(userMenuBtn, "Switch to Lightning Experience");
        return new LightningPage(driver);
    }*/

    /*public DeveloperConsolePage navigateToDeveloperConsole()  {
        selectByVisibleText(userMenuBtn, "Developer Console");
        return new DeveloperConsolePage(driver);
    }*/
}
