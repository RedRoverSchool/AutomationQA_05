package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolQ() {
        final String symbol = "Q";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category Q";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/q.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
