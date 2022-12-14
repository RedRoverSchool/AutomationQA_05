package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.LuaLanguagePage;
import pages.browse_languages.letters.LPage;

public class LuaLanguageTest extends BaseTest {

    @Test
    public void testLuaLanguageLink_NavigatesTo_LuaLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-lua-365.html";
        final String expectedTitle = "99 Bottles of Beer | Language LUA";

        LuaLanguagePage luaLanguagePage = new LuaLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickLSubmenu()
                .getURL();

        new LPage(getDriver()).clickLuaLanguage();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = luaLanguagePage.getURL();
        String actualTitle = luaLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);

        luaLanguagePage.clickRedditLink();

        Assert.assertNotEquals(actualUrl, getDriver().getCurrentUrl());
    }
}
