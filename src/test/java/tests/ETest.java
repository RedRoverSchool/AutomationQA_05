package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.EnglishLanguagePage;
import pages.browse_languages.letters.EPage;

public class ETest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolE() {
        final String symbol = "E";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category E";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/e.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }

    @Test
    public void testEnglishLink_NavigatesTo_EnglishLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-english-966.html";
        final String expectedTitle = "99 Bottles of Beer | Language English";

        EnglishLanguagePage englishLanguagePage = new EnglishLanguagePage(getDriver());

        String oldTitle = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickESubmenu()
                .getEPageTitle();

        new EPage(getDriver()).clickEnglishLink();

        Assert.assertNotEquals(oldTitle, getDriver().getTitle());

        String actualURL = englishLanguagePage.getURL();
        String actualTitle = englishLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
