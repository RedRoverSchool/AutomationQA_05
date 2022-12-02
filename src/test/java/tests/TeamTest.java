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
                .clickStartMenu()
                .clickTeamSubmenu()
                .clickOliverSchadeWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedLsLaNetLink_OliverSchade);
    }

    @Test
    public void testClickabilityETasteOrgLink_GregorScheithauer() {
        String expectedETasteOrgLink_GregorScheithauer = "http://www.e-taste.org/";

        openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .clickGregorScheithauerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedETasteOrgLink_GregorScheithauer);
    }

    @Test
    public void testClickabilityStsSynfloodDe_StefanScheler() {
        String expectedStsSynfloodDe_StefanScheler = "http://sts.synflood.de/";

        openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .clickStefanSchelerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedStsSynfloodDe_StefanScheler);
    }

    @Test
    public void testTeamNames() {
        List<String> expectedTeamNames = new ArrayList<>(
                Arrays.asList("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));

        List<String> actualTeamNames =
        openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .getTeamNames();

        Assert.assertEquals(actualTeamNames, expectedTeamNames);
    }
}
