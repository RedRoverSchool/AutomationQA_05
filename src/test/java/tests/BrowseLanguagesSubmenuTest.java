package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.ABCPage;
import pages.browse_languages.letters.NPage;

public class BrowseLanguagesSubmenuTest extends BaseTest {

    @Test
    public void testLinkAndSymbolA() {
        final String symbol = "A";
        final String expectedLinkURL = "https://www.99-bottles-of-beer.net/a.html";

        BrowseLanguagesSubmenuPage browseLanguagesSubmenuPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        String actualResultCurrentURL = browseLanguagesSubmenuPage.getURL();

        Boolean actualResultContainsSymbol = browseLanguagesSubmenuPage
                .getListSymbolsInSubmenu()
                .contains(symbol);

        Assert.assertTrue(actualResultContainsSymbol);

        String actualLinktURL = browseLanguagesSubmenuPage
                .getLinkBySymbol(symbol);

        Assert.assertEquals(actualLinktURL, expectedLinkURL);

        browseLanguagesSubmenuPage.clickASubmenu();

        Assert.assertNotEquals(actualResultCurrentURL, expectedLinkURL);
    }

    @Test
    public void testNSymbolTextAndLink() {

        final String expectedSymbol = "N";
        final String expectedLink = "https://www.99-bottles-of-beer.net/n.html";

        NPage nPage = new NPage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getABCPageURL();

        new ABCPage(getDriver()).clickNSubmenu();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualSymbol = nPage.getNSubmenu();
        String actualLink = nPage.getHrefN("href");

        Assert.assertEquals(actualSymbol, expectedSymbol);
        Assert.assertEquals(actualLink, expectedLink);
    }
}
