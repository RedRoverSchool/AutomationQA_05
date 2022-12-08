package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.AdaLanguagePage;

public class AdaLanguageTest extends BaseTest {

    @Test
    public void testChoosingLanguageAda() {
        final String expectedLanguageName = "Language Ada";
        final String expectedLanguageURL = "https://www.99-bottles-of-beer.net/language-ada-19.html";
        final String expectedLanguageTitle = "99 Bottles of Beer | Language Ada";

        AdaLanguagePage adaLanguagePage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .clickAdaLanguageLink();

        Assert.assertEquals(adaLanguagePage.getURL(), expectedLanguageURL);
        Assert.assertEquals(adaLanguagePage.getTitle(), expectedLanguageTitle);
        Assert.assertEquals(adaLanguagePage.getH2HeaderText(), expectedLanguageName);
    }
}
