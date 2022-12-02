package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABCTest extends BaseTest {

    @Test
    public void testDefaultHeaderForABCPage() {
        String expectedH2Header = "Category A";

        String actualH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getH2Header();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}
