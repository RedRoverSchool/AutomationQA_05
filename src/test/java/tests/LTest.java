package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolL() {
        final String symbol = "L";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category L";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/l.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
