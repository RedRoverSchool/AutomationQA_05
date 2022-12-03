package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ATest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolA() {
        final String symbol = "A";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category A";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/a.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
