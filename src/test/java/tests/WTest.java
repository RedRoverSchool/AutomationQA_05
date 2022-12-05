package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolW() {
        final String symbol = "W";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category W";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/w.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
