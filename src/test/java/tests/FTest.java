package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolF() {
        final String symbol = "F";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category F";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/f.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
