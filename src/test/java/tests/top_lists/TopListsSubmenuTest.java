package tests.top_lists;

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
}
