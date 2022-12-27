package tests.start;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.HistoryPage;

public class HistoryTest extends BaseTest {

    @Test
    public void testLinkText_HistorySubmenu() {
        final String expectedText = "History";
        final String expectedSubmenuInfoLink = "info.html";

        openBaseURL();

        HistoryPage historyPage = new HistoryPage(getDriver());

        String actualText = historyPage.getHistorySubmenuText();
        String actualHrefValue = historyPage.getHistorySubmenuHref();

        Assert.assertEquals(expectedText, actualText);
        Assert.assertTrue(actualHrefValue.contains(expectedSubmenuInfoLink));
    }

    @Test
    public void testHistorySubmenu_NavigatesTo_HistorySubmenuPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/info.html";
        final String expectedTitle = "99 Bottles of Beer | Background and historic information";

        HistoryPage historyPage = new HistoryPage(getDriver());

        String actualURL = openBaseURL()
                .clickHistorySubmenu().getURL();
        String actualTitle = historyPage.getTitle();

        Assert.assertNotEquals(openBaseURL().getURL(), actualURL);

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testRegularTextOnSubmenuInfo() {
        final String expectedRegularText = "This site bases on work done by Tim Robinson during 1994 - 1998.";

        String actualRegularText =
                openBaseURL()
                        .clickHistorySubmenu()
                        .getFirstParagraphText();

        Assert.assertEquals(actualRegularText, expectedRegularText);
    }

    @Test
    public void testNumberOfImages() {
        final int expectedNumberOfImages = 2;

        int actualNumberOfImages = openBaseURL()
                .clickHistorySubmenu()
                .countHistoryPageImages();

        Assert.assertEquals(actualNumberOfImages, expectedNumberOfImages);
    }
}
