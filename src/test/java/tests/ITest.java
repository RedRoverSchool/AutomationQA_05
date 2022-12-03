package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ITest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolI() {
        final String symbol = "I";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category I";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/i.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
