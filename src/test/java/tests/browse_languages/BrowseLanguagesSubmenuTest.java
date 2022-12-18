package tests.browse_languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.BrowseLanguagesSubmenuPage;
import pages.browse_languages.letters.ABCPage;
import pages.browse_languages.letters.NPage;

import java.util.List;

public class BrowseLanguagesSubmenuTest extends BaseTest {

    @Test
    public void testASubmenuLink() {
        final String expectedLink = "https://www.99-bottles-of-beer.net/a.html";

        String actualLink =  openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .getURL();

        Assert.assertEquals(actualLink, expectedLink);
    }

    @Test
    public void testNSymbolTextAndLink() {
        final String expectedSymbol = "N";
        final String expectedLink = "https://www.99-bottles-of-beer.net/n.html";

        NPage nPage = new NPage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getURL();

        new ABCPage(getDriver()).clickNSubmenu();

        Assert.assertNotEquals(oldURL, nPage.getURL());

        String actualSymbol = nPage.getNSubmenuText();
        String actualLink = nPage.getHrefN();

        Assert.assertEquals(actualSymbol, expectedSymbol);
        Assert.assertEquals(actualLink, expectedLink);
    }

    @Test
    public void testTextAndLinksSubmenu() {
        final List<String> expectedlettersSubmenu = List.of("0-9","A", "B", "C", "D", "E", "F", "G", "H", "I"
                , "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        BrowseLanguagesSubmenuPage browseLanguagesSubmenuPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        List<String> actualSubmenusNames = browseLanguagesSubmenuPage.getSubmenusNames();

        Assert.assertEquals(actualSubmenusNames, expectedlettersSubmenu);
    }
}
