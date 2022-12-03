package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolX() {
        final String symbol = "X";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category X";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/x.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
