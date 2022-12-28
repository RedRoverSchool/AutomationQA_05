package tests.start;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TeamTest extends BaseTest {

    @Test
    public void testLsLaNetLink_NavigatesTo_ExternalOliverSchadePage() {
        final String expectedExternalURL = "http://www.ls-la.net/";
        final String expectedExternalTitle = "Index of /";

        openBaseURL()
                .clickTeamSubmenu()
                .clickOliverSchadeWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }

    @Test
    public void testETasteOrgLink_NavigatesTo_ExternalGregorScheithauer() {
        final String expectedExternalURL = "http://www.e-taste.org/";
        final String expectedExternalTitle = "Ce domaine a été enregistré par Youdot.io";

        openBaseURL()
                .clickTeamSubmenu()
                .clickGregorScheithauerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }

    @Test
    public void testStsSynfloodDe_NavigatesTo_ExternalStefanScheler() {
        final String expectedExternalURL = "http://sts.synflood.de/";
        final String expectedExternalTitle = "sts.synflood.de";

        openBaseURL()
                .clickTeamSubmenu()
                .clickStefanSchelerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
    }

    @Test
    public void testH2Header() {
        final String expectedHeader = "The Team";

        String actualHeader =
                openBaseURL()
                        .clickTeamSubmenu()
                        .getH2HeaderText();

        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void testTeamNames() {
        final List<String> expectedTeamNames = List.of(
                "Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"
        );

        List<String> actualTeamNames =
                openBaseURL()
                        .clickTeamSubmenu()
                        .getH3HeadersTexts();

        Assert.assertEquals(actualTeamNames, expectedTeamNames);
    }

    @Test
    public void testTeamLinks() {
        final List<String> expectedTeamLinks = List.of("ls-la.net", "E-Taste.org", "sts.synflood.de");

        List<String> actualTeamLinks =
                openBaseURL()
                        .clickTeamSubmenu()
                        .getTeamLinks();

        Assert.assertEquals(actualTeamLinks, expectedTeamLinks);
    }

    @Test
    public void testTwoImagesOfTeamCreators() {
        final int expectedTwoImagesOfTeamCreators = 2;

        int actualTwoImagesOfTeamCreators =
                openBaseURL()
                        .clickTeamSubmenu()
                        .countTeamImages();

        Assert.assertEquals(actualTwoImagesOfTeamCreators, expectedTwoImagesOfTeamCreators);
    }
}
