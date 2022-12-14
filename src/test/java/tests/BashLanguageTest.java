package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.BashLanguagePage;

public class BashLanguageTest extends BaseTest {

    @Test
    public void testFooterChoosingLanguageBASH() {
        final String expectedLanguageName = "Language BASH";
        final String expectedLanguageURL = "https://www.99-bottles-of-beer.net/language-bash-1815.html";
        final String expectedLanguageTitle = "99 Bottles of Beer | Language BASH";

        BashLanguagePage bashLanguagePage = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickBSubmenu()
                .clickBashLanguageLink();

        Assert.assertEquals(bashLanguagePage.getURL(), expectedLanguageURL);
        Assert.assertEquals(bashLanguagePage.getTitle(), expectedLanguageTitle);
        Assert.assertEquals(bashLanguagePage.getH2HeaderText(), expectedLanguageName);
    }

    @Test
    public void testBookmarkActive() {
        final int expectedActiveBookmark = 14;

        int activeBookmark = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickBSubmenu()
                .clickBashLanguageLink()
                .getExternalLinks()
                .size();

        Assert.assertEquals(activeBookmark, expectedActiveBookmark);
    }
}