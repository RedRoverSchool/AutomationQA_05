package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.LuaLanguagePage;

public class LuaLanguageTest extends BaseTest {

    @Test
    public void testLuaLanguagePageHeader() {
        final String expectedH2Header = "Language LUA";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickLSubmenu()
                        .clickLuaLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testJoveProhostingComLink_NavigatesTo_ExternalLuaLanguagePage() {
        final String expectedExternalURL = "http://jove.prohosting.com/~philho/";
        final String expectedExternalTitle = "jove.prohosting.com";

        String oldLuaLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickLSubmenu()
                        .getURL();

        LuaLanguagePage luaLanguagePage = new LuaLanguagePage(getDriver());

        luaLanguagePage.clickLuaLanguageInfoLink();

        Assert.assertNotEquals(oldLuaLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }
}
