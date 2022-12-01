package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABCTest extends BaseTest {

    @Test
    public void testABCPageURL() {
        String expectedURL = "https://www.99-bottles-of-beer.net/abc.html";

        String actualPageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getExternalPageURL();
        Assert.assertEquals(actualPageURL, expectedURL);
    }
}
