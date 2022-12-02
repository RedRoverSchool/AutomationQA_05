package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolM() {
        final String symbol = "M";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category M";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/m.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
