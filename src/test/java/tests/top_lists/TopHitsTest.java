package tests.top_lists;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.ShakespeareLanguagePage;
import pages.top_lists.TopHitsPage;

public class TopHitsTest extends BaseTest {

    @Test
    public void testShakespeareLink_NavigatesTo_ShakespeareLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-shakespeare-664.html";
        final String expectedTitle = "99 Bottles of Beer | Language Shakespeare";

        ShakespeareLanguagePage shakespeareLanguagePage = new ShakespeareLanguagePage(getDriver());

        String oldUrl = openBaseURL()
                .clickTopListsMenu()
                .clickTopHitsSubmenu()
                .getURL();

        new TopHitsPage(getDriver()).clickShakespeareLanguage();
        Assert.assertNotEquals(oldUrl, getDriver().getCurrentUrl());

        String actualUrl = shakespeareLanguagePage.getURL();
        String actualTitle = shakespeareLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
