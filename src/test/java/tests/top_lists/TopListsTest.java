package tests.top_lists;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopListsTest extends BaseTest {

    @Test
    public void testH2HeaderText() {
        final String expectedResult = "Top Rated";

        String actualResult =
                openBaseURL()
                        .clickTopListsMenu()
                        .getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
