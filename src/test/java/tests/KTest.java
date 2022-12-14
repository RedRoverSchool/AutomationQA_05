package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;
import pages.browse_languages.letters.KPage;

import java.util.List;

public class KTest extends BaseTest {

    @Test
    public void testAllLanguagesNamesOnKPageStartWithLetterK() {
        final String FIRST_LETTER = "K";

        List<String> languagesNamesInUpperCase = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesInUpperCase.size() > 0);

        for (String languageName : languagesNamesInUpperCase) {
            Assert.assertEquals(languageName.toUpperCase().substring(0, 1), FIRST_LETTER);
        }
    }

    @Test
    public void testKotlinLink_NavigatesTo_KotlinLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-kotlin-2901.html";
        final String expectedTitle = "99 Bottles of Beer | Language Kotlin";

        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickKSubmenu()
                .getURL();

        new KPage(getDriver()).clickKotlinLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = kotlinLanguagePage.getURL();
        String actualTitle = kotlinLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
