package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.LyricsPage;

public class StartSubmenuTest extends BaseTest {

    @Test
    public void  testSongLyricsSubMenuNavigatesToSongLyricsPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";

        LyricsPage songLyricsSubmenuPage = openBaseURL().clickSongLyricsSubmenu();

        String actualURL = songLyricsSubmenuPage. getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void  testSongLyricsSubmenuButtonText() {
        final String expectedSongLyricsSubmenuText = "Song Lyrics";

        String actualSongLyricsSubmenuText = openBaseURL().getSongLyricsSubmenuText();

        Assert.assertEquals(actualSongLyricsSubmenuText, expectedSongLyricsSubmenuText);
    }
}
