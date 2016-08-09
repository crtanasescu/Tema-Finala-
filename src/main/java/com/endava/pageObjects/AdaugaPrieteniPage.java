package com.endava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by crtanasescu on 8/9/2016.
 */
public class AdaugaPrieteniPage extends BasePage {
    public AdaugaPrieteniPage(WebDriver webDriver) {super(webDriver); }


    @FindBy(xpath = "(//div[@class='FriendButton'])[1]")
    private WebElement adaugaPrieten;

    @FindBy(xpath = "//div[@id='userNavigationLabel']")
    private WebElement optionsMenu;

    @FindBy(xpath = "//ul[@role='menu']/li[12]/a/span")
    private WebElement logOutButton;

    public void clickAdaugaPrieten(){
        wait(2000);
        adaugaPrieten.click();
    }

    public void clickOptionsMenu(){
        wait(2000);
        optionsMenu.click();
    }

    public HomePage clickLogOut(){
        wait(2000);
        logOutButton.click();
        return new HomePage(webDriver);
    }



}
