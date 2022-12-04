package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCommentsTest extends BaseTest {

    @Test
    public void testPageNewCommentsH2() {
        final String expectedResultH2Text = "New Comments";
        final String expectedResultCurrentURL = "https://www.99-bottles-of-beer.net/newcomments.html";

        String actualdResultH2Text = openBaseURL()
                .clickTopListsMenu()
                .clickNewCommentsSubmenu()
                .getH2HeaderText();

        String actualdResultCurrentURL = getExternalPageURL();

        Assert.assertEquals(actualdResultH2Text, expectedResultH2Text);
        Assert.assertEquals(actualdResultCurrentURL, expectedResultCurrentURL);
    }
}
