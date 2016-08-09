package com.endava.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.List;

/**
 * Created by crtanasescu on 8/8/2016.
 */
public class WelcomeToFacebook extends BasePage {

    //constructor
    public WelcomeToFacebook(WebDriver webDriver) {
        super(webDriver);
    }


    //locatori


    @FindBy(xpath = "//textarea[@name='xhpc_message']")
    private WebElement postingField;


    @FindBy(xpath = "//div[@id='feedx_container']//button")
    private WebElement postButton;

    @FindBy(xpath = "//a[@data-testid='blue_bar_profile_link']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[@data-testid='left_nav_item_Photos']")
    private WebElement photosButton;

    @FindBy(xpath = "//input[@placeholder='Find friends']")
    private WebElement findFriends;
    @FindBy(xpath = "//a[@id='findFriendsNav']")
    private WebElement findFriendsButton;


    //functii

    public void postarePeWall(String mesaj) {
        wait(500);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(postingField));
        wait.until(ExpectedConditions.elementToBeClickable(postingField));

        postingField.click();
        Actions action = new Actions(webDriver);
        action.sendKeys(mesaj).build().perform();

        wait(500);
        wait.until(ExpectedConditions.elementToBeClickable(postButton));
        postButton.click();


    }

    public Timeline catreTimeline() {
        wait(2500);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));

        profileButton.click();

        Timeline timeline = PageFactory.initElements(webDriver, Timeline.class);
        return timeline;
    }


    public String getLastSharedMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@aria-label='Story']"), 0));
        List<WebElement> posts = webDriver.findElements(By.xpath("//div[@aria-label='Story']"));

        for (int i = 0; i < posts.size(); i++) {
            WebElement post = posts.get(i);
            try {
                if (post.findElement(By.xpath(".//span/span[1]")).getText().contains(" shared her ")) {
                    return post.findElement(By.xpath(".//p")).getText();
                }
            } catch (Exception ex) {
            }
        }

        return "";
    }

    public AdaugaPrieteniPage clickFindFriendsButton() {
        wait(10000);

        WebElement findFriendsButton = webDriver.findElement(By.xpath("//a[@id='findFriendsNav']"));
        findFriendsButton.click();

        AdaugaPrieteniPage adaugaPrieteniPage = PageFactory.initElements(webDriver, AdaugaPrieteniPage.class);
        return adaugaPrieteniPage;
    }


}
