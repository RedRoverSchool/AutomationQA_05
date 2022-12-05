package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolH() {
        final String symbol = "H";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category H";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/h.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
