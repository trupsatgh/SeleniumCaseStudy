package org.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement pwd;
    @FindBy(xpath = "//div[@id='error']")
    WebElement loginErrorMsg;
    @FindBy(xpath = "//*[@id='Login']")
    WebElement loginBtn;
    @FindBy(xpath = "//*[@id='rememberUn']")
    WebElement rememberMe;
    @FindBy(xpath = " //span[@id=\"idcard-identity\"]")
    WebElement idCard;
    @FindBy(xpath = "//*[@id='forgot_password_link']")
    WebElement forgotPasswordLink;
    @FindBy(xpath = ".//*[@id='un']")
    WebElement userNameEmail;
    @FindBy(xpath = ".//*[@id='un']")
    WebElement continueBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String usernameData) {
        username.sendKeys(usernameData);
    }

    public void enterUserDetails(String usernameData, String pwdData) {
        username.sendKeys(usernameData);
        pwd.sendKeys(pwdData);
    }

    public String loginValidCredentials(String usernameData, String pwdData) {
        username.sendKeys(usernameData);
        pwd.sendKeys(pwdData);
        loginBtn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public HomePage loginToGeHomePage(String usernameData, String pwdData) {
        username.sendKeys(usernameData);
        pwd.sendKeys(pwdData);
        loginBtn.click();
        //click on home tab
        return new HomePage(driver);
    }

    public String clickLoginBtn() {
        click(loginBtn);
        if (loginErrorMsg != null) {
            return getErrorMsg(loginErrorMsg);
        } else {
            return driver.getTitle();
        }
    }

    public void checkRememberMe() {
        clickCheckBox(rememberMe);
    }

    public String getIdCardText() {
        return getText(idCard);
    }

    public void clickOnForgotPassword() {
        click(forgotPasswordLink);
    }

    public void clickOnContinue() {
        click(continueBtn);
    }

    public void enterUserNameEmail(String usernameEmailData) {
        userNameEmail.sendKeys(usernameEmailData);
    }
}