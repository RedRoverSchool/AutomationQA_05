package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolJ() {
        final String symbol = "J";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category J";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/j.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
