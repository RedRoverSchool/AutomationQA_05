package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolV() {
        final String symbol = "V";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category V";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/v.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
