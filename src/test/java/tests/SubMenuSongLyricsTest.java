package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SongLyricsSubmenuPage;

public class SubMenuSongLyricsTest extends BaseTest {
//    @Test
//    public void testSongLyricsSubmenu1() {
//        final String expectedSubmenuSongLyricsTitle = "Song Lyrics";
//        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";
//
//        String actualSubmenuSongLyricsTitle = openBaseURL()
//                .clickSongLyricsSubmenuPage()
//                .getSongLyricsSubmenuLabelText();
//
//        Assert.assertEquals(actualSubmenuSongLyricsTitle, expectedSubmenuSongLyricsTitle);
//
//        String actualURL = openBaseURL()
//                .clickSongLyricsSubmenuPage()
//                .getDriver().getCurrentUrl();
//
//        Assert.assertEquals(actualURL, expectedURL);
//    }

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







