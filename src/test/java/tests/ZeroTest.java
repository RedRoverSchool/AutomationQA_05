package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZeroTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbol09() {
        final String symbol = "0-9";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category 0-9";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/0.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
