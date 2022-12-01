package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
