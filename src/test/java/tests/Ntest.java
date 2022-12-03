package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ntest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolN() {
        final String symbol = "N";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category N";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/n.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
