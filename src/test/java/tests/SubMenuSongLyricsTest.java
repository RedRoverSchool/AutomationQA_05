package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SongLyricsSubmenuPage;

public class SubMenuSongLyricsTest extends BaseTest {

    @Test
    public void testSongLyricsSubmenuText() {
        final String expectedSongLyricsSubmenuText = "Song Lyrics";
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";

        SongLyricsSubmenuPage songLyricsSubmenuPage = openBaseURL().clickSongLyricsSubmenuPage();

        String actualsongLyricsSubmenuText = openBaseUrl().getSongLyricsSubmenuText();

        String actualURL = songLyricsSubmenuPage. getExternalPageURL();

        Assert.assertEquals(actualsongLyricsSubmenuText, expectedSongLyricsSubmenuText);
        Assert.assertEquals(actualURL, expectedURL);
    }
}
