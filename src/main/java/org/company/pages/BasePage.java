package org.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    // declare webdriver
    protected  WebDriver driver;
    WebDriverWait wait ;
    Select select ;

    //constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public void waitForElement(WebElement element) {
       wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public String getErrorMsg(WebElement element){
        return element.getText();
    }

    public String getTitle(BasePage page){
        return driver.getTitle();
    }

    public void clickCheckBox(WebElement element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectByIndex(WebElement element,int index){
        wait.until(ExpectedConditions.visibilityOf(element));
        select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectByVisibleText(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        select = new Select(element);
        select.selectByValue(value);
    }

    public String getText(WebElement element){
       return element.getText();
    }


    /*public static void clickObj(WebElement obj,String objName)
    {
        if(obj.isDisplayed())
        {
            obj.click();
            System.out.println("pass :" +objName + "button is clicked");
        }
        else
        {
            System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
        }*/
}



