package tests.start;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.ReadGuestbookPage;
import pages.start.HistoryPage;
import pages.start.LyricsPage;
import pages.start.StartPage;
import pages.start.TeamPage;
import pages.submit_new_language.SubmitNewLanguagePage;

import java.util.List;

public class StartTest extends BaseTest {

    @Test(priority = -5, suiteName = "Smoke", alwaysRun = true)
    public void testBaseURLLoadedSuccessfully() {

        StartPage startPage = openBaseURL();

        String actualURL = startPage.getURL();
        String actualTitle = startPage.getTitle();

        String h1LogoHeader = startPage.getH1LogoHeaderText();
        String h2LogoHeader = startPage.getH2LogoHeaderText();

        Assert.assertEquals(actualURL, getBaseUrl());
        Assert.assertEquals(actualTitle, "99 Bottles of Beer | Start");
        Assert.assertEquals(h1LogoHeader, "99 Bottles of Beer");
        Assert.assertEquals(h2LogoHeader, "one program in 1500 variations");
    }

    @Test(priority = -4, dependsOnMethods = "testBaseURLLoadedSuccessfully")
    public void testClickStartFromHomepage() {
        String actualURL =
                openBaseURL()
                        .clickStartMenu()
                        .getURL();

        Assert.assertEquals(actualURL, getBaseUrl());
    }

    @Test(priority = -3, dependsOnMethods = {"testBaseURLLoadedSuccessfully", "testClickStartFromHomepage"})
    public void testBaseURLShown_WhenLandingToStartPage() {
        final String expectedUrl = getBaseUrl();

        String actualUrl =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickStartMenu()
                        .getURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 5, suiteName = "Total Regression")
    public void testWishesFromTheTeamFirstParagraph() {
        final String WISHES_FROM_THE_TEAM = "This Website holds a collection of the Song 99 Bottles of Beer programmed in different programming languages. " +
                "Actually the song is represented in 1500 different programming languages and variations. " +
                "For more detailed information refer to historic information.";

        String teamWishes = openBaseURL()
                .getFirstParagraphText();

        Assert.assertEquals(teamWishes, WISHES_FROM_THE_TEAM);
    }

    @Test(dependsOnMethods = "testTextsWithLinksOnStartPage")
    public void testHeaderTextH2() {
        final String expectedHeaderH2 = "Welcome to 99 Bottles of Beer";

        String actualHeader = openBaseURL()
                .getH2HeaderText();

        Assert.assertEquals(actualHeader, expectedHeaderH2);
    }

    @Test
    public void testTextsWithLinksOnStartPage() {
        final List<String> expectedTextsWithLinks = List.of(
                "historic information",
                "here",
                "submit your own piece of code",
                "guestbook",
                "team members"
        );

        List<String> actualTextsWithLinks =
                openBaseURL()
                        .getTextsWithLinks();

        Assert.assertEquals(actualTextsWithLinks, expectedTextsWithLinks);
    }

    @Test
    public void testHistoricInformationLink_NavigatesTo_HistoryPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/info.html";
        final String expectedTitle = "99 Bottles of Beer | Background and historic information";

        HistoryPage historyPage = new HistoryPage(getDriver());
        StartPage startPage = new StartPage(getDriver());

        String oldURL = openBaseURL().getURL();
        String actualURL = startPage.clickHistoricInformationLink().getURL();

        Assert.assertNotEquals(oldURL, actualURL);

        String actualTitle = historyPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testHereLink_NavigatesTo_LyricsPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/lyrics.html";
        final String expectedTitle = "99 Bottles of Beer | The lyrics to the song 99 Bottles of Beer";

        LyricsPage lyricsPage = new LyricsPage(getDriver());

        String oldURL =
                openBaseURL()
                        .getURL();

        new StartPage(getDriver()).clickHereLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = lyricsPage.getURL();
        String actualTitle = lyricsPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testSubmitYourOwnPieceOfCodeLink_NavigatesTo_SubmitNewLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";
        final String expectedTitle = "99 Bottles of Beer | Submit new Language";

        SubmitNewLanguagePage submitNewLanguagePage = new SubmitNewLanguagePage(getDriver());

        String oldURL =
                openBaseURL()
                        .getURL();

        new StartPage(getDriver()).clickSubmitYourOwnPieceOfCodeLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = submitNewLanguagePage.getURL();
        String actualTitle = submitNewLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dependsOnMethods = "testHeaderTextH2")
    public void testGuestbookLink_NavigatesTo_GuestbookV2Page() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/guestbookv2.html";
        final String expectedTitle = "99 Bottles of Beer | Guestbook";

        ReadGuestbookPage readGuestBookPage = new ReadGuestbookPage(getDriver());

        String oldURL =
                openBaseURL()
                        .getURL();

        new StartPage(getDriver()).clickGuestbookLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = readGuestBookPage.getURL();
        String actualTitle = readGuestBookPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testTeamMembersLink_NavigatesTo_TeamPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/team.html";
        final String expectedTitle = "99 Bottles of Beer | The Team";

        TeamPage teamPage = new TeamPage(getDriver());

        String oldURL =
                openBaseURL()
                        .getURL();

        new StartPage(getDriver()).clickTeamMembersLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = teamPage.getURL();
        String actualTitle = teamPage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
