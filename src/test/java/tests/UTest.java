package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolU() {
        final String symbol = "U";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category U";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/u.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
