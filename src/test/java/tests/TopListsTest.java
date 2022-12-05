package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopListsTest extends BaseTest {

    @Test
    public void testVerifyH2HeaderTextOnTopListsPage()  {

        final String expectedResult = "Top Rated";

        String actualResult =
                openBaseURL()
                        .clickTopListsMenu()
                        .getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
