package com.endava.pageObjects;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


/**
 * Created by crtanasescu on 8/8/2016.
 */
public class FacebookTest extends TestBaseClass {
    protected static WebDriver webDriver;

    @Test
    public void Facebook() {

        //autentificare pe Facebook
        WelcomeToFacebook welcomeToFacebook = homePage.logareFacebook("cristina.tanasescu@endava.com", "Parola3#");


        //postare pe wall
        String mesaj = "Facebook is cool! " + System.currentTimeMillis();
        welcomeToFacebook.postarePeWall(mesaj);
        Timeline timeline = welcomeToFacebook.catreTimeline();
        String mesajPostatPeFacebook = timeline.getUltimulMesajPostat();

        assertEquals(mesaj, mesajPostatPeFacebook);


        //modificarea unui post de pe wall
        timeline.optiuniMesajPostat();
        timeline.editareUltimaPostare("Am i right?");

        assertEquals(mesaj + " Am i right?", timeline.getUltimulMesajPostat());


        //share la un articol de pe wall
        timeline.share();
        wait(3000);
        welcomeToFacebook = timeline.clickHomeIcon();
        welcomeToFacebook.refreshPage();

        assertEquals(mesaj + " Am i right?", welcomeToFacebook.getLastSharedMessage());


        //adaugarea unui prieten
        welcomeToFacebook.clickFindFriendsButton();
        AdaugaPrieteniPage adaugaPrieteniPage = welcomeToFacebook.clickFindFriendsButton();
        adaugaPrieteniPage.clickAdaugaPrieten();


        //logout
        adaugaPrieteniPage.clickOptionsMenu();
        adaugaPrieteniPage.clickLogOut();

        assertTrue(webDriver.getCurrentUrl().contains("Facebook.com"));
    }
}
