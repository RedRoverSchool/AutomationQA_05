package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolO() {
        final String symbol = "O";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category O";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/o.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
