package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolP() {
        final String symbol = "P";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category P";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/p.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
