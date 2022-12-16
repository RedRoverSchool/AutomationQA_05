package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;
import pages.browse_languages.letters.KPage;

import java.util.List;

public class KTest extends BaseTest {

    @Test
    public void testAllLanguagesNamesStartWithLetterK() {
        final String letterK = "K";

        List<String> languagesNamesInUpperCase = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesInUpperCase.size() > 0);

        for (String languageName : languagesNamesInUpperCase) {
            Assert.assertEquals(languageName.toUpperCase().substring(0, 1), letterK);
        }
    }

    @Test
    public void testKotlinLink_NavigatesTo_KotlinLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-kotlin-2901.html";
        final String expectedTitle = "99 Bottles of Beer | Language Kotlin";

        KPage kPage = new KPage(getDriver());
        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickKSubmenu()
                .getURL();

        String actualURL = kPage.clickKotlinLanguage().getURL();
        String actualTitle = kotlinLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
