package tests.start;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.LyricsPage;
import utils.TestUtils;

public class LyricsTest extends BaseTest {

    @Test
    public void testH2Header_WhenChooseSubmenuLyrics() {
        final String expectedResult = "Lyrics of the song 99 Bottles of Beer";

        String actualResult =
                openBaseURL()
                        .clickSongLyricsSubmenu()
                        .getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAmountOfPTags_WhenChooseSubmenuLyrics() {
        final int expectedResult = 100;

        int actualResult =
                openBaseURL()
                        .clickSongLyricsSubmenu()
                        .countParagraphs();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLyricsLink_NavigatesTo_LyricsPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";
        final String expectedTitle = "99 Bottles of Beer | The lyrics to the song 99 Bottles of Beer";

        LyricsPage LyricsPage = new LyricsPage(getDriver());

        String actualUrl = openBaseURL()
                .clickSongLyricsSubmenu()
                .getURL();

        new LyricsPage(getDriver()).clickSongLyricsSubmenu();

        String actualTitle = LyricsPage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void test99BottlesSongLyrics() {
        final String expectedSongLyrics = TestUtils.createSongLyrics();

        String actualSongLyrics = openBaseURL()
                .clickSongLyricsSubmenu()
                .getSongLyrics();

        Assert.assertEquals(actualSongLyrics, expectedSongLyrics);
    }
}