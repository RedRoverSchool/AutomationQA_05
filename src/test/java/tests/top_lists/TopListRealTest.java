package tests.top_lists;

import base.BaseTest;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopListRealTest extends BaseTest {

    @Test
    public void testH2Text_WhenChoosingTopRatedRealSubmenu() {
        final String expectedH2HeaderText = "Top Rated Real Languages";

        String actualH2HeaderText = openBaseURL()
                .clickTopListsMenu()
                .clickTopRatedRealSubmenu()
                .getH2HeaderText();

        Assert.assertEquals(actualH2HeaderText, expectedH2HeaderText);
    }

    @Test
    public void testH2Color_WhenChoosingTopRatedRealSubmenu() {
        final String expectedHexColor = "#1b651c";

        String headerTextCssValue = openBaseURL()
                .clickTopListsMenu()
                .clickTopRatedRealSubmenu()
                .getH2HeaderColor();
        String actualHexColor = Color.fromString(headerTextCssValue).asHex();

        System.out.println(Color.fromString(headerTextCssValue));

        Assert.assertEquals(actualHexColor, expectedHexColor);
    }
}
