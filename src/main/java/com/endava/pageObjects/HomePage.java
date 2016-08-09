package com.endava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by crtanasescu on 8/8/2016.
 */


public class HomePage extends BasePage {

    //constructor


    public HomePage(WebDriver webDriver) {super(webDriver); }

    //locatori

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//label[@id='loginbutton']/input")
    private WebElement loginButton;

    //functii

    public WelcomeToFacebook logareFacebook(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();


        WelcomeToFacebook welcomeToFacebook = PageFactory.initElements(webDriver, WelcomeToFacebook.class);

        return welcomeToFacebook;

    }


}
