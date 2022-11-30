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

    @Test
    public void testHeaderH2Text_WhenOpenBrowseLanguageMenu_BSubmenu() {

        final String expectedHeader = "Category B";

        String actualHeader = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .getHeaderH2BSubmenuText();

        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
