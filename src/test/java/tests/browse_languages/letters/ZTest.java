package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.ZimLanguagePage;
import pages.browse_languages.letters.ZPage;

import java.util.List;

public class ZTest extends BaseTest {

    @Test
    public void testLanguagesNamesStartWithZ() {
        final String letterZ = "z";

        List<String> zLanguages = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickZSubmenu()
                .getNamesInLowerCase();

        Assert.assertTrue(zLanguages.size() > 0);
        for (String language : zLanguages) {
            Assert.assertEquals(String.valueOf(language.charAt(0)), letterZ);
        }
    }

    @Test
    public void testZimLink_NavigatesTo_ZimLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-zim-718.html";
        final String expectedTitle = "99 Bottles of Beer | Language Zim";

        ZPage zPage = new ZPage(getDriver());
        ZimLanguagePage ZimLanguagePage = new ZimLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickZSubmenu()
                .getURL();

        String actualUrl = zPage.clickZimLanguage().getURL();
        String actualTitle = ZimLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());
        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testH2Header() {
        final String expectedResult = "Category Z";

        String actualResult = openBaseURL()
                .clickTopListsMenu()
                .clickTopHitsSubmenu()
                .clickBrowseLanguagesFooterMenu()
                .clickZSubmenu()
                .getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
