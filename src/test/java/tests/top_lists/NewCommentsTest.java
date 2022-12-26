package tests.top_lists;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCommentsTest extends BaseTest {

    @Test
    public void testPageNewCommentsH2() {
        final String expectedH2Text = "New Comments";
        final String expectedURL = "https://www.99-bottles-of-beer.net/newcomments.html";

        String actualH2Text = openBaseURL()
                .clickTopListsMenu()
                .clickNewCommentsSubmenu()
                .getH2HeaderText();

        String actualURL = getExternalPageURL();

        Assert.assertEquals(actualH2Text, expectedH2Text);
        Assert.assertEquals(actualURL, expectedURL);
    }
}
