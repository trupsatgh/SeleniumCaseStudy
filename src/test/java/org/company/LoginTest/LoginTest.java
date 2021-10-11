package org.company.LoginTest;


import org.company.base.BaseTest;

import org.company.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Parameters({ "browserName"})
    @BeforeMethod
    public void setup(@Optional final String browser) throws IOException {
        initialization(browser);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login Error Message - 1",enabled=false)
    public void LoginErrorMessage1()  {
        String usernameData = prop.getApplicationProperty("username");
        loginPage.enterUserDetails(usernameData, "");
        String actualMsg = loginPage.clickLoginBtn();
        Assert.assertEquals(actualMsg, "Please enter your password.");
    }

    @Test(description = "Login To SalesForce -2",enabled=true)
    public void LoginToSalesForce2(){
        String usernameData = prop.getApplicationProperty("username");
        String pwdData = prop.getApplicationProperty("pwd");
        String actualTitle = loginPage.loginValidCredentials(usernameData, pwdData);
        driver.manage().window().maximize();
        String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(description = "Check Remember Me - 3",enabled = false)
    public void CheckRememberMe(){}

    @Test(description = "ForgotPassword TC_4A",enabled = false)
    public void TC_4A_ForgotPassword() {
        String usernameData = prop.getApplicationProperty("username");
        loginPage.enterUserName(usernameData);
        loginPage.clickOnForgotPassword();
        loginPage.enterUserNameEmail(usernameData);
        loginPage.clickOnContinue();
    }

    @Test(description = "ForgotPassword TC_4B",enabled = false)
    public void TC_4B_ValidateLoginErrorMessage() {
        loginPage.enterUserDetails("invalidUser", "invalidPwd");
        pause(2000);
        String actualMsg = loginPage.clickLoginBtn();
        String expectedMSg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator." ;
        Assert.assertEquals(actualMsg, expectedMSg);

    }

}
