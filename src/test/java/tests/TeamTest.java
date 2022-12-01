package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
