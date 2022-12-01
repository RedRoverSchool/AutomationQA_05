package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SongLyricsSubmenuPage;

public class StartSubmenuTest extends BaseTest {

    @Test
    public void  testSongLyricsSubMenuNavigatesToSongLyricsPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";

        SongLyricsSubmenuPage songLyricsSubmenuPage = openBaseURL().clickSongLyricsSubmenuButton();

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
