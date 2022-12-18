package tests.browse_languages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.browse_languages.BrowseLanguagesSubmenuPage;
import pages.browse_languages.letters.ABCPage;
import pages.browse_languages.letters.NPage;
import utils.StaticProvider;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

    @Test
    public void test_API_AllLanguagesLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getSubmenus();

        final int expectedWorkingLinksCount = aTags.size();
        int internalLinks = expectedWorkingLinksCount;

        for (WebElement link : aTags) {
            linkURL = link.getAttribute("href");

            if (linkURL != null && !linkURL.isBlank() && !linkURL.isEmpty()) {
                if (!linkURL.startsWith(getBaseUrl())) {
                    Reporter.log(linkURL + " is externalLink ", true);
                    internalLinks--;
                } else {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) (new URL(linkURL).openConnection());
                        connection.setRequestMethod("HEAD");
                        connection.connect();

                        responseCode = connection.getResponseCode();

                        if (responseCode < 400) {
                            actualWorkingLinksCount++;
                        } else {
                            Reporter.log(linkURL + " is broken, responseCode " + responseCode, true);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Assert.assertEquals(actualWorkingLinksCount, internalLinks);
        Assert.assertEquals(actualWorkingLinksCount, expectedWorkingLinksCount);
    }

    @Test(dataProviderClass = StaticProvider.class, dataProvider = "lettersSubmenu")
    public void testLetterSubmenuNavigate(
            int index, String symbol, String url, String title) {

        ABCPage abcPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        String oldURL = abcPage.getURL();
        String oldTitle = abcPage.getTitle();
        String actualSymbol =  abcPage.getTextSymbol(index);
        String actualURLHref = abcPage.getHref(index);

        abcPage.clickOnSymdolSubmenu(index);

        String actualURL = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        if (index != 1) {
            Assert.assertNotEquals(actualURL, oldURL);
            Assert.assertNotEquals(actualTitle, oldTitle);
        }

        Assert.assertEquals(actualSymbol, symbol);
        Assert.assertEquals(actualURLHref, url);
        Assert.assertEquals(actualURL, url);
        Assert.assertEquals(actualTitle, title);
    }
}
