package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.start.HistoryPage;

public class HistoryTest extends BaseTest {

    @Test
    public void testLabelTextSubmenuInfo(){
//        final String expectedLinkText = "History";
//
//        openBaseURL();
//        HistoryPage historyPage = new HistoryPage(getDriver());
//
//        String actualSubmenuTitle = historyPage.getInfoSubMenuLabelText();
//
//        Assert.assertEquals(actualSubmenuTitle, expectedSubmenuInfoTitle);
    }

    @Test
    public void testLinkTextSubmenuInfo(){
        final String attribute = "href";
        final String expectedSubmenuInfoLink = "info.html";

        openBaseURL();

        HistoryPage historyPage = new HistoryPage(getDriver());

        String actualHrefValue = historyPage.getHref(attribute);

        Assert.assertTrue(actualHrefValue.contains(expectedSubmenuInfoLink));
    }

    @Test
    public void testClickOnSubmenuInfo(){
        final String expectedURL = "https://www.99-bottles-of-beer.net/info.html";
        final String expectedTitle = "99 Bottles of Beer | Background and historic information";

        HistoryPage historyPage = new HistoryPage(getDriver());

        openBaseURL()
                .clickHistorySubmenu();

        String actualURL = historyPage.getURL();
        String actualTitle = historyPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
