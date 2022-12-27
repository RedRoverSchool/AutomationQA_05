package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.LiLiLanguagePage;

public class LiLiLanguageTest extends BaseTest {

    @Test
    public void testLuaLanguagePageHeader() {
        final String expectedH2Header = "Language LiLi";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickLSubmenu()
                        .clickLiLiLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testLiLiInfoLink_NavigatesTo_ExternalLiLiLanguagePage() {
        final String expectedExternalURL = "https://littlisp.sourceforge.net/";
        final String expectedExternalTitle = "The Lili Lisp Dialect Interpreter";

        String oldLuaLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickLSubmenu()
                        .clickLiLiLanguage()
                        .getURL();

        LiLiLanguagePage liLiLanguagePage = new LiLiLanguagePage(getDriver());

        liLiLanguagePage.clickLiLiLanguageInfoLink();

        Assert.assertNotEquals(oldLuaLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }
}
