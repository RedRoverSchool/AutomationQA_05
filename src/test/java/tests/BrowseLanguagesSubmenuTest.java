package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.BrowseLanguagesSubmenuPage;
import pages.browse_languages.letters.ABCPage;
import pages.browse_languages.letters.NPage;

public class BrowseLanguagesSubmenuTest extends BaseTest {

    @Test
    public void testLinkAndSymbolA() {
        final String symbol = "A";
        final String expectedLinktURL = "https://www.99-bottles-of-beer.net/a.html";

        BrowseLanguagesSubmenuPage browseLanguagesSubmenuPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        String actualResultCurrentURL = browseLanguagesSubmenuPage.getURL();

        Boolean actualResultContainsSymbol = browseLanguagesSubmenuPage
                .getListSymbolsInSubmenu()
                .contains(symbol);

        String actualLinktURL = browseLanguagesSubmenuPage
                .getLinkBySymbol(symbol);

        Assert.assertTrue(actualResultContainsSymbol);
        Assert.assertEquals(actualLinktURL, expectedLinktURL);

        browseLanguagesSubmenuPage.clickASubmenu();

        Assert.assertNotEquals(actualResultCurrentURL, expectedLinktURL);
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
