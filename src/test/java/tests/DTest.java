package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolD() {
        final String symbol = "D";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category D";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/d.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
