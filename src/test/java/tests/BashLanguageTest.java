package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BashLanguageTest extends BaseTest {

    @Test
    public void testFooterChoosingLanguageBASH() {
        final String expectedLanguageName = "Language BASH";
        final String expectedLanguageURL = "https://www.99-bottles-of-beer.net/language-bash-1815.html";
        final String expectedLanguageTitle = "99 Bottles of Beer | Language BASH";

        String actualLanguageName = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickBSubmenu()
                .clickBashLanguageLink()
                .getH2HeaderText();


        Assert.assertEquals(getDriver().getCurrentUrl(), expectedLanguageURL);
        Assert.assertEquals(getDriver().getTitle(), expectedLanguageTitle);
        Assert.assertEquals(actualLanguageName, expectedLanguageName);
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