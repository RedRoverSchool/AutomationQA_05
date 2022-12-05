package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamTest extends BaseTest {

    @Test
    public void testClickabilityLsLaNetLink_OliverSchade() {
        String expectedLsLaNetLink_OliverSchade = "http://www.ls-la.net/";

        openBaseURL()
                .clickTeamSubmenu()
                .clickOliverSchadeWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedLsLaNetLink_OliverSchade);
    }

    @Test
    public void testClickabilityETasteOrgLink_GregorScheithauer() {
        String expectedETasteOrgLink_GregorScheithauer = "http://www.e-taste.org/";

        openBaseURL()
                .clickTeamSubmenu()
                .clickGregorScheithauerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedETasteOrgLink_GregorScheithauer);
    }

    @Test
    public void testClickabilityStsSynfloodDe_StefanScheler() {
        String expectedStsSynfloodDe_StefanScheler = "http://sts.synflood.de/";

        openBaseURL()
                .clickTeamSubmenu()
                .clickStefanSchelerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedStsSynfloodDe_StefanScheler);
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
        List<String> expectedTeamNames = List.of("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler");

        List<String> actualTeamNames =
        openBaseURL()
                .clickTeamSubmenu()
                .getTeamNames();

        Assert.assertEquals(actualTeamNames, expectedTeamNames);
    }

    @Test
    public void testTeamLinks() {
        List<String> expectedTeamLinks = List.of("ls-la.net", "E-Taste.org", "sts.synflood.de");

        List<String> actualTeamLinks =
                openBaseURL()
                        .clickTeamSubmenu()
                        .getTeamLinks();

        Assert.assertEquals(actualTeamLinks, expectedTeamLinks);
    }
}
