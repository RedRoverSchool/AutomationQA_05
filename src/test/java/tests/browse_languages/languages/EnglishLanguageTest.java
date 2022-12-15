package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.EnglishLanguagePage;

public class EnglishLanguageTest extends BaseTest {

    @Test
    public void testEnglishLanguagePageHeader() {
        final String expectedH2Header = "Language English";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickESubmenu()
                        .clickEnglishLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testFormLinkNavigatesToSubmitNewLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickESubmenu()
                .clickEnglishLanguage()
                .clickWriteComment()
                .getURL();

        EnglishLanguagePage englishLanguagePage = new EnglishLanguagePage(getDriver());
        String actualURL = englishLanguagePage
                .clickFormReference()
                .getURL();

        Assert.assertNotEquals(oldURL,actualURL);
        Assert.assertEquals(actualURL,expectedURL);







    }
}
