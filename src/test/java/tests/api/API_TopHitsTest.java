package tests.api;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_lists.TopHitsPage;

import static utils.TestUtils.getBaseUrl;

public class API_TopHitsTest extends BaseTest {
    final static String HEADER_NAME = "Top Hits";
    final static String ACTION_TOP_HITS = "tophits.html";

    @Test
    public void testAttributes_DefaultValuesTopHits() {
        TopHitsPage topHitsPage =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopHitsSubmenu();

        Assert.assertEquals(topHitsPage.getURL(), getBaseUrl() + ACTION_TOP_HITS);
        Assert.assertEquals(topHitsPage.getH2HeaderText(), HEADER_NAME);
    }
}
