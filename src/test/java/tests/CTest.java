package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.CheetahLanguagePage;
import pages.browse_languages.letters.CPage;

import java.util.List;

public class CTest extends BaseTest {
    @Test
    public void testABCNavigationSubmenuClickLetterC() {
        String expectedFirstLetter = "C";

        List<String> languagesNamesInUpperCase = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickCSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesInUpperCase.size() > 0);

        for (String languageName : languagesNamesInUpperCase) {
            Assert.assertEquals(
                    languageName.toUpperCase().substring(0, 1), expectedFirstLetter
            );
        }
    }

    @Test
    public void testCheetahLink_NavigatesTo_CheetahLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-cheetah-1179.html";
        final String expectedTitle = "99 Bottles of Beer | Language Cheetah";

        CheetahLanguagePage cheetahLanguagePage = new CheetahLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickCSubmenu()
                .getURL();

        new CPage(getDriver()).clickCheetahLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = cheetahLanguagePage.getURL();
        String actualTitle = cheetahLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
