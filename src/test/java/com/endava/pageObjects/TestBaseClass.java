package com.endava.pageObjects;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by crtanasescu on 8/8/2016.
 */
public class TestBaseClass {
    protected static WebDriver webDriver;
    protected HomePage homePage;

    @BeforeClass
    public static void setUp() {


        //Navigate to "https://www.facebook.com/"
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.facebook.com/");

    }

    protected void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }

    @Before
    public void initPageObjects() {
        homePage = PageFactory.initElements(webDriver, HomePage.class);
    }

//@AfterClass
//    public static void tearDown(){
//        webDriver.close();
//    }


}
