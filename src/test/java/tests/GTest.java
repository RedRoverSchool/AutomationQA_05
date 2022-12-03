package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolG() {
        final String symbol = "G";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category G";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/g.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
