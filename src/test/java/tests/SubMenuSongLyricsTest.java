package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubMenuSongLyricsTest extends BaseTest {
    @Test
    public void testSongLyricsSubmenu() {
        final String expectedSubmenuSongLyricsTitle = "Song Lyrics";
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";

        openBaseURL();

        String actualSubmenuSongLyricsTitle = openBaseURL()
                .clickSongLyricsSubmenuPage()
                .getSongLyricsSubmenuLabelText();

        Assert.assertEquals(actualSubmenuSongLyricsTitle, expectedSubmenuSongLyricsTitle);

        String actualURL = openBaseURL()
                .clickSongLyricsSubmenuPage()
                .getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }
}







