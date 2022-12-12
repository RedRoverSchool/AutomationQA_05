package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TopListsSubmenuTest extends BaseTest {

    @Test
    public void testTopListsSubmenuTexts() {
        List<String> expectedSubmenuTexts = new ArrayList<>();
        expectedSubmenuTexts.add("Top Rated");
        expectedSubmenuTexts.add("Top Rated Real");
        expectedSubmenuTexts.add("Top Rated Esoteric");
        expectedSubmenuTexts.add("Top Rated Assembly");
        expectedSubmenuTexts.add("Top Hits");
        expectedSubmenuTexts.add("New Languages this month");
        expectedSubmenuTexts.add("New Comments");

        List<String> actualSubmenuTexts =
                openBaseURL()
                        .clickTopListsMenu()
                        .getSubmenusTexts();

        Assert.assertTrue(actualSubmenuTexts.size() > 0);
        Assert.assertEquals(actualSubmenuTexts, expectedSubmenuTexts);
    }

    @Test
    public void testTopListsSubMenuIsVisibleAndClickable() {
        int expectedCountSubMenuLinks = 7;
        List<String> topListsSubMenuLinkTexts = List.of("Top Rated", "Top Rated Real"
                , "Top Rated Esoteric", "Top Rated Assembly", "Top Hits"
                , "New Languages this month", "New Comments");

        int actualCountSubMenuLinks = openBaseURL()
                .clickTopListsMenu()
                .getSubmenusTexts().size();

        List <String>  actualTopListSubMenuLinkTexts = openBaseURL()
                .clickTopListsMenu()
                .getSubmenusTexts();
        ///
        openBaseURL().clickTopListsMenu().clickTopListsSubmenuLinks();

        Assert.assertEquals(actualCountSubMenuLinks, expectedCountSubMenuLinks);
        Assert.assertEquals(actualTopListSubMenuLinkTexts, topListsSubMenuLinkTexts);
    }
}
