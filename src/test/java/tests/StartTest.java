package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static utils.TestUtils.getBaseUrl;

public class StartTest extends BaseTest {

    @Test
    public void testClickStartFromHomepage() {

        String urlAfterClickingStartFromHomepage =
                openBaseURL()
                        .clickStartMenu()
                        .getURL();

        Assert.assertEquals(urlAfterClickingStartFromHomepage, getBaseUrl());
    }

    @Test
    public void testBaseURLShown_WhenLandingToStartPage() {
        final String expectedUrl = getBaseUrl();

        String actualUrl =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickStartMenu()
                        .getURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void testWishesFromTheTeamFirstParagraph() {
        final String WISHES_FROM_THE_TEAM = "This Website holds a collection of the Song 99 Bottles of Beer programmed in different programming languages. " +
                "Actually the song is represented in 1500 different programming languages and variations. " +
                "For more detailed information refer to historic information.";

        String teamWishes = openBaseURL()
                .getTeamWishes();

        Assert.assertEquals(teamWishes, WISHES_FROM_THE_TEAM);
    }

    @Test
    public void testHeaderTextH2() {
        final String expectedHeaderH2 = "Welcome to 99 Bottles of Beer";

        String actualHeader = openBaseURL()
                .getH2();

        Assert.assertEquals(actualHeader, expectedHeaderH2);
    }

    @Test
    public void testTextsWithLinksOnStartPage() {
        List<String> expectedTextsWithLinks =
                List.of("historic information", "here", "submit your own piece of code", "guestbook", "team members");

        List<String> actualTextsWithLinks =
                openBaseURL()
                        .getTextsWithLinks();

        Assert.assertEquals(actualTextsWithLinks, expectedTextsWithLinks);
    }
}
