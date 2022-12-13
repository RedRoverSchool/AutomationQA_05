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
    public void testTopListsSubMenuLinksNavigateToCorrectPages() {
        int expectedCountSubMenuLinks = 7;

        ArrayList<String> expectedSubmenuH2HeaderTexts = new ArrayList<>();
        expectedSubmenuH2HeaderTexts.add("Top Rated");
        expectedSubmenuH2HeaderTexts.add("Top Rated Real Languages");
        expectedSubmenuH2HeaderTexts.add("Top Rated Esoteric Languages");
        expectedSubmenuH2HeaderTexts.add("Top Rated Assembly Languages");
        expectedSubmenuH2HeaderTexts.add("Top Hits");
        expectedSubmenuH2HeaderTexts.add("New Languages this month");
        expectedSubmenuH2HeaderTexts.add("New Comments");

        int actualCountSubMenuLinks = openBaseURL()
                .clickTopListsMenu()
                .getSubmenusTexts().size();

        Assert.assertEquals(actualCountSubMenuLinks, expectedCountSubMenuLinks);

        ArrayList<String> actualSubmenuH2HeaderTexts = openBaseURL().clickTopListsMenu().clickTopListsSubmenuLinksAndGetH2Header();

        Assert.assertEquals(expectedSubmenuH2HeaderTexts, actualSubmenuH2HeaderTexts);
    }
}
