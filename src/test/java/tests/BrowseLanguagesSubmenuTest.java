package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowseLanguagesSubmenuTest extends BaseTest {

    @Test
    public void testLinkText_WhenNavigatingFromStartToBrowseLanguageAndLetterNLink() {

        final String expectedText = "N";

        String actualText = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickNSubmenu().
                getNSubmenuLinkText();

        Assert.assertEquals(actualText, expectedText);
    }
}
