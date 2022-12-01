package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowseLanguagesSubmenuTest extends BaseTest {

    @Test
    public void testLinkText_WhenNavigatingFromStartToBrowseLanguageAndLetterNLink() {

        final String expectedText = "N";

        String actualText = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickNSubmenu().
                getNSubmenuLinkText();

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testVerifyTextAndLink() {
        final String symbol = "0-9";
        final String expectedResultHrefURL = "https://www.99-bottles-of-beer.net/0.html";

        Assert.assertTrue(
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getListSymbolsInSubmenu()
                        .contains(symbol));

        Assert.assertEquals(
                openBaseURL()
                .clickBrowseLanguagesMenu()
                .getLinkBySymbol(symbol), expectedResultHrefURL);
    }
}
