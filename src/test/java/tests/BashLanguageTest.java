package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BashLanguageTest extends BaseTest {

    @Test
    public void testVerifyingFooterChoosingLanguage() {
        final String LANGUAGE_NAME = "BASH";

        String actualLanguageName = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickBSubmenu()
                .clickBashLanguageLink()
                .getH2HeaderText();

        Assert.assertTrue(actualLanguageName.contains(LANGUAGE_NAME));
    }

    @Test
    public void testBookmarkActive() {
        final int expectedActiveBookmark = 14;

        int activeBookmark = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickBSubmenu()
                .clickBashLanguageLink()
                .getExternalLinksList()
                .size();

        Assert.assertEquals(activeBookmark, expectedActiveBookmark);
    }
}