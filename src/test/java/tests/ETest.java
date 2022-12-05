package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ETest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolE() {
        final String symbol = "E";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category E";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/e.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
