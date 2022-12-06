package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.ABCPage;
import pages.browse_languages.letters.NPage;

public class Ntest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolN() {
        final String symbol = "N";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category N";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/n.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }

    @Test
    public void testTextAndLinkN() {
        final String expectedSymbol = "N";
        final String expectedURL = "https://www.99-bottles-of-beer.net/n.html";

        NPage nPage = new NPage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getABCPageURL();

        new ABCPage(getDriver()).clickNSubmenu();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualSymbol = nPage.getNSubmenu();
        String actualURL = nPage.getURL();

        Assert.assertEquals(actualSymbol, expectedSymbol);
        Assert.assertEquals(actualURL, expectedURL);
    }
}
