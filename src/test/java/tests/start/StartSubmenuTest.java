package tests.start;

import testData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.LyricsPage;
import pages.start.StartSubmenuPage;

import java.util.List;

public class StartSubmenuTest extends BaseTest {

    @Test
    public void testSongLyricsSubMenuNavigatesToSongLyricsPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";

        LyricsPage songLyricsSubmenuPage = openBaseURL().clickSongLyricsSubmenu();

        String actualURL = songLyricsSubmenuPage.getURL();

        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testSongLyricsSubmenuButtonText() {
        final String expectedSongLyricsSubmenuText = "Song Lyrics";

        String actualSongLyricsSubmenuText = openBaseURL().getSongLyricsSubmenuText();

        Assert.assertEquals(actualSongLyricsSubmenuText, expectedSongLyricsSubmenuText);
    }

    @Test
    public void testStartSubmenuButtonsNames() {
        List<String> expectedStartSubmenuButtonsNames = List.of(
                "Team", "Song Lyrics", "History", "Privacy"
        );

        List<String> actualStartSubmenuButtonsNames =
                openBaseURL()
                        .getStartSubmenuButtonsText();

        Assert.assertEquals(actualStartSubmenuButtonsNames, expectedStartSubmenuButtonsNames);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "StartSubmenu")
    public void testFooterStartSubmenusNavigateToCorrespondingPages(
            int index, String submenuText, String urlHref, String url, String title) {

        StartSubmenuPage startSubmenuPage = openBaseURL()
                .clickStartFooterMenu();

        List<WebElement> startSubmenus = startSubmenuPage
                .getStartSubmenus();

        String oldUrl = startSubmenuPage.getURL();
        String oldTitle = startSubmenuPage.getTitle();

        String actualUrl = startSubmenuPage
                .clickMenu(index, startSubmenus)
                .getURL();

        String actualTitle = startSubmenuPage
                .clickMenu(index, startSubmenus)
                .getTitle();

        Assert.assertNotEquals(actualUrl, oldUrl);
        Assert.assertNotEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualTitle, title);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "StartSubmenu")
    public void testStartSubmenuNavigateToCorrespondingPages(
            int index, String submenuText, String urlHref, String url, String title) {

        StartSubmenuPage startSubmenuPage =
                openBaseURL();

        List<WebElement> startSubmenus =
                startSubmenuPage
                        .getStartSubmenus();

        String oldUrl = startSubmenuPage.getURL();
        String oldTitle = startSubmenuPage.getTitle();
        String oldH2Text = startSubmenuPage.getH2HeaderText();

        String actualUrl =
                startSubmenuPage
                        .clickMenu(index, startSubmenus)
                        .getURL();
        String actualTitle =
                startSubmenuPage
                        .clickMenu(index, startSubmenus)
                        .getTitle();
        String actualH2Text =
                startSubmenuPage
                        .clickMenu(index, startSubmenus)
                        .getH2HeaderText();
        String actualNameSubmenu =
                startSubmenuPage
                        .getTextStartSubmenu(index);
        String actualURLHref =
                startSubmenuPage
                        .getHref(index);

        Assert.assertEquals(actualNameSubmenu, submenuText);
        Assert.assertEquals(actualURLHref, urlHref);

        if (index != 0) {
            Assert.assertNotEquals(actualUrl, oldUrl);
            Assert.assertNotEquals(actualTitle, oldTitle);
            Assert.assertNotEquals(actualH2Text, oldH2Text);
        }

        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualTitle, title);
    }
}
