package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolK() {
        final String symbol = "K";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category K";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/k.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
