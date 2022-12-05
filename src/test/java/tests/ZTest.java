package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolZ() {
        final String symbol = "Z";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category Z";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/z.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
