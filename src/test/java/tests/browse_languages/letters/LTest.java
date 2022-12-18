package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.LiLiLanguagePage;
import pages.browse_languages.letters.LPage;

public class LTest extends BaseTest {

    @Test
    public void testLuaLanguageLink_NavigatesTo_LuaLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-lili-1603.html";
        final String expectedTitle = "99 Bottles of Beer | Language LiLi";

        LiLiLanguagePage liLiLanguagePage = new LiLiLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickLSubmenu()
                .getURL();

        new LPage(getDriver()).clickLiLiLanguage();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = liLiLanguagePage.getURL();
        String actualTitle = liLiLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);

        liLiLanguagePage.clickRedditLink();

        Assert.assertNotEquals(actualUrl, getDriver().getCurrentUrl());
    }
}
