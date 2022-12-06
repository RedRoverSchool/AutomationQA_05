package tests;

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

        LuaLanguagePage LuaLanguagePage = new LuaLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickLSubmenu()
                .getLPageURL();

        new LPage(getDriver()).clickLuaLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = LuaLanguagePage.getURL();
        String actualTitle = LuaLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);

        LuaLanguagePage.clickRedditLink();

        Assert.assertNotEquals(actualUrl, getDriver().getCurrentUrl());
    }
}
