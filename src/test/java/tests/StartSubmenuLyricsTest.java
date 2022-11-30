package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartSubmenuLyricsTest extends BaseTest {

    @Test
    public void testH2TagText_WhenChooseSubmenuLyrics() {
        String expectedResult = "Lyrics of the song 99 Bottles of Beer";

        String actualResult =
                openBaseURL()
                        .clickLyricsStartSubmenu()
                        .getH2TagText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testPTagText_WhenChooseSubmenuLyrics() {
        int expectedResult = 100;

        int actualResult =
                openBaseURL()
                        .clickLyricsStartSubmenu()
                        .getAmountPTagText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
