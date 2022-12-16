package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.CheetahLanguagePage;
import pages.browse_languages.letters.CPage;

import java.util.List;

public class CTest extends BaseTest {

    @Test
    public void testAllLanguagesStartWithLetterC() {
        final String letterC = "C";

        List<String> languagesNamesInUpperCase = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickCSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesInUpperCase.size() > 0);

        for (String languageName : languagesNamesInUpperCase) {
            Assert.assertEquals(languageName.substring(0, 1), letterC);
        }
    }

    @Test
    public void testCheetahLanguageLink_NavigatesTo_CheetahLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-cheetah-1179.html";
        final String expectedTitle = "99 Bottles of Beer | Language Cheetah";

        CPage cPage = new CPage(getDriver());
        CheetahLanguagePage cheetahLanguagePage = new CheetahLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickCSubmenu()
                .getURL();

        String newURL = cPage.clickCheetahLanguage().getURL();
        String actualTitle = cheetahLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, newURL);
        Assert.assertEquals(newURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
