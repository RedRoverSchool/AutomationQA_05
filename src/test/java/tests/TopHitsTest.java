package tests;

import base.BaseTest;
import org.openqa.selenium.devtools.v101.domsnapshot.model.StringIndex;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.ShakespeareLanguagePage;
import pages.top_lists.TopHitsPage;
import pages.top_lists.TopListsPage;
import pages.top_lists.TopListsSubmenuPage;

import java.util.List;

public class TopHitsTest extends BaseTest {

    @Test
    public void testShakespeareLink_NavigatesTo_ShakespeareLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-shakespeare-664.html";
        final String expectedTitle = "99 Bottles of Beer | Language Shakespeare";

        ShakespeareLanguagePage shakespeareLanguagePage =
                new ShakespeareLanguagePage(getDriver());

        String oldUrl = openBaseURL()
                .clickTopListsMenu()
                .clickTopHitsSubmenu()
                .getTopHitsPageURL();

        new TopHitsPage(getDriver()).clickShakespeareLink();
        Assert.assertNotEquals(oldUrl, getDriver().getCurrentUrl());

        String actualUrl = shakespeareLanguagePage.getURL();
        String actualTitle = shakespeareLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testTopListsSubMenuIsVisible() {
        int expectedCountSubMenuLinks = 7;
        List<String> topListsSubMenuLinkTexts = List.of("Top Rated", "Top Rated Real"
                , "Top Rated Esoteric", "Top Rated Assembly", "Top Hits"
                , "New Languages this month", "New Comments");

        int actualCountSubMenuLinks = openBaseURL()
                .clickTopListsMenu()
                .getSubmenusTexts().size();

        List <String>  actualTopListSubMenuLinkTexts = openBaseURL()
                .clickTopListsMenu()
                .getSubmenusTexts();
        ///
        openBaseURL().clickTopListsMenu().clickTopListsSubmenuLinks();

        Assert.assertEquals(actualCountSubMenuLinks, expectedCountSubMenuLinks);
        Assert.assertEquals(actualTopListSubMenuLinkTexts, topListsSubMenuLinkTexts);
    }
}
