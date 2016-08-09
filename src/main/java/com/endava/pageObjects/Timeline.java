package com.endava.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by crtanasescu on 8/8/2016.
 */
public class Timeline extends BasePage {

    //constructor

    public Timeline(WebDriver webDriver) {
        super(webDriver);
    }


    //locatori
    @FindBy(xpath = "(//div[@aria-label='Story']//div[contains(@class,'userContent')]/p[1])[1]")
    private WebElement ultimulMesajPostat;

    @FindBy(xpath = "(//a[@aria-label='Story options'])[1]")
    private WebElement postOptionsMenu;

    @FindBy(xpath = "(//li[@data-feed-option-name='FeedEditOption'])[1]")
    private WebElement editPost;

    @FindBy(xpath = "//div[@class = 'clearfix']//div[@role = 'combobox']")
    private WebElement editField;

    @FindBy(xpath = "//button[@data-testid='react-composer-post-button']")
    private WebElement submitEditField;

    @FindBy(xpath = "(//div[@aria-label='Story']//a[contains(@class,'share_action_link')])[1]")
    private WebElement shareButton;

    @FindBy(xpath = "//ul[@role='menu']/li[1]/a[contains(@ajaxify,'share')]")
    private WebElement shareWithFriends;

    @FindBy(xpath = "//div[@data-click='home_icon']/a")
    private WebElement homeIcon;

    //functii
    public String getUltimulMesajPostat() {
        wait(1000);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(ultimulMesajPostat));
        return ultimulMesajPostat.getText();
    }

    public void optiuniMesajPostat() {

        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(postOptionsMenu));
        wait(1000);
        postOptionsMenu.click();


        wait.until(ExpectedConditions.elementToBeClickable(editPost));
        editPost.click();
    }

    public void editareUltimaPostare(String message) {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(editField));

        Actions action = new Actions(webDriver);
        //action.sendKeys()

        //editField.click();
        editField.sendKeys(Keys.SPACE);
        editField.sendKeys(message);
        submitEditField.click();

        wait(3000);

    }

    public void share() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        //webDriver.findElement(By.linkText("Share")).click();
        Actions action = new Actions(webDriver);
        action.moveToElement(shareButton).build().perform();
        action.click(shareButton).build().perform();

        wait(1000);
        shareWithFriends.click();
    }

    public WelcomeToFacebook clickHomeIcon() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(homeIcon));
        wait.until(ExpectedConditions.elementToBeClickable(homeIcon));
        wait(3000);
        homeIcon.click();
        return new WelcomeToFacebook(webDriver);

    }
}
