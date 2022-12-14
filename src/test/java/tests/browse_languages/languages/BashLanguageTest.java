package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.BashLanguagePage;

public class BashLanguageTest extends BaseTest {

    @Test
    public void testBashLanguagePageHeader() {
        final String expectedH2Header = "Language BASH";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickBSubmenu()
                        .clickBashLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testFrLangFreeFrCoursLink_NavigatesTo_ExternalBashLanguagePage() {
        final String expectedExternalURL = "http://fr.lang.free.fr/cours";
        final String expectedExternalTitle = "Frédéric Lang - Site Personnel";

        String oldBashLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .clickBashLanguage()
                        .getURL();

        BashLanguagePage bashLanguagePage = new BashLanguagePage(getDriver());

        bashLanguagePage.clickBashLanguageInfoLink();

        Assert.assertNotEquals(oldBashLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }

    @Test
    public void testBookmarkActive() {
        final int expectedActiveBookmark = 14;

        int activeBookmark =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickBSubmenu()
                        .clickBashLanguage()
                        .getExternalLinks()
                        .size();

        Assert.assertEquals(activeBookmark, expectedActiveBookmark);
    }
}