package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.DelphiLanguagePage;
import pages.browse_languages.letters.DPage;

import java.util.List;

public class DTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolD() {
        final String symbol = "D";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category D";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/d.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
}

    @Test
    public void testABCNavigationSubmenuLetterD_languagesNamesStartFromLetterD(){
        String expectedLetter = "D";
        List<String> languagesNamesList = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickDSubmenu()
                .getNamesInUpperCase();
        Assert.assertTrue(languagesNamesList.size() > 0);
        for(String languageName:languagesNamesList){
            Assert.assertEquals(languageName.substring(0, 1),expectedLetter);
        }
    }

    @Test
    public void testDelphiLink_NavigatesTo_DelphiLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-delphi-867.html";
        final String expectedTitle = "99 Bottles of Beer | Language Delphi";

        DelphiLanguagePage delphiLanguagePage = new DelphiLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickDSubmenu()
                .getDPageUPL();

        new DPage(getDriver()).clickDelphiLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = delphiLanguagePage.getURL();
        String actualTitle = delphiLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
