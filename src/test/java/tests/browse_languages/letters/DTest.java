package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.DelphiLanguagePage;
import pages.browse_languages.letters.DPage;

import java.util.List;

public class DTest extends BaseTest {

    @Test
    public void testLanguagesNamesStartWithLetterD() {
        final String letterD = "D";

        List<String> languagesNamesList = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickDSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesList.size() > 0);
        for (String languageName : languagesNamesList) {

            Assert.assertEquals(languageName.substring(0, 1), letterD);
        }
    }

    @Test
    public void testDelphiLink_NavigatesTo_DelphiLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-delphi-867.html";
        final String expectedTitle = "99 Bottles of Beer | Language Delphi";

        DPage dPage = new DPage(getDriver());
        DelphiLanguagePage delphiLanguagePage = new DelphiLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickDSubmenu()
                .getURL();

        String newURL = dPage.clickDelphiLanguage().getURL();
        String actualTitle = delphiLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, newURL);
        Assert.assertEquals(newURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
