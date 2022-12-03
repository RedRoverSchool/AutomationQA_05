package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTest extends BaseTest {
    @Test
    public void testVerifyNavigationSymbolT() {
        final String symbol = "T";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category T";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/t.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
