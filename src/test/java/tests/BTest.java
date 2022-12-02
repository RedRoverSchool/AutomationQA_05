package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BTest extends BaseTest {

    @Test
    public void testH2Header() {

        final String expectedHeader = "Category B";

        String actualHeader = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .getH2Header();

        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
