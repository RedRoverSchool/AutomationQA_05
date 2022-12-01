package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SongLyricsSubmenuPage;

public class SubMenuSongLyricsTest extends BaseTest {

    @Test
    public void testSongLyricsSubmenu() {
        final String expectedSubmenuSongLyricsTitle = "Song Lyrics";
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";

        SongLyricsSubmenuPage songLyricsSubmenuPage = openBaseURL().clickSongLyricsSubmenuPage();

        String actualSubmenuSongLyricsTitle = songLyricsSubmenuPage.getSongLyricsSubmenuLabelText();

        String actualURL = songLyricsSubmenuPage. getExternalPageURL();

        Assert.assertEquals(actualSubmenuSongLyricsTitle, expectedSubmenuSongLyricsTitle);
        Assert.assertEquals(actualURL, expectedURL);
    }
}
