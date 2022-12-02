package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolR() {
        final String symbol = "R";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category R";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/r.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
