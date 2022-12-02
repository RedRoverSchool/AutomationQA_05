package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolB() {
        final String symbol = "B";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category B";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/b.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
