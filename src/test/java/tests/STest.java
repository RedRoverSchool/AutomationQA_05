package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class STest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolS() {
        final String symbol = "S";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category S";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/s.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
