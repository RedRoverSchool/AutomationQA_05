package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.LyricsPage;

public class LyricsTest extends BaseTest {

    @Test
    public void testH2Header_WhenChooseSubmenuLyrics() {
        String expectedResult = "Lyrics of the song 99 Bottles of Beer";

        String actualResult =
                openBaseURL()
                        .clickSongLyricsSubmenu()
                        .getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAmountOfPTags_WhenChooseSubmenuLyrics() {
        int expectedResult = 100;

        int actualResult =
                openBaseURL()
                        .clickSongLyricsSubmenu()
                        .getAmountOfPTags();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLyricsLink_NavigatesTo_LyricsPage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";
        final String expectedTitle = "99 Bottles of Beer | The lyrics to the song 99 Bottles of Beer";

        LyricsPage LyricsPage = new LyricsPage(getDriver());

        String actualUrl = openBaseURL()
                .clickSongLyricsSubmenu()
                .getLyricsPageURL();

        new LyricsPage(getDriver()).clickLyricsLink();

        String actualTitle = LyricsPage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
