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
    public void testSymbolAndLink() {
        final String symbol = "0-9";
        final String expectedResultURL = "https://www.99-bottles-of-beer.net/0.html";

        Boolean actualResultTrue =
                openBaseURL()
                .clickBrowseLanguagesMenu()
                .getListSymbolsInSubmenu()
                .contains(symbol);

        String actualResultURL =
                openBaseURL()
                .clickBrowseLanguagesMenu()
                .getLinkBySymbol(symbol);

        Assert.assertTrue(actualResultTrue);
        Assert.assertEquals(actualResultURL, expectedResultURL);
    }
}
