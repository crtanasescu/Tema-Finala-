package com.endava.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

/**
 * Created by crtanasescu on 8/8/2016.
 */
@SuppressWarnings("ALL")
public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    protected void wait(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }

    public void refreshPage()
    {
        webDriver.navigate().refresh();
    }

}
