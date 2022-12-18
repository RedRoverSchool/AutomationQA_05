package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.EnglishLanguagePage;
import pages.browse_languages.letters.EPage;

public class ETest extends BaseTest {

    @Test
    public void testEnglishLink_NavigatesTo_EnglishLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-english-966.html";
        final String expectedTitle = "99 Bottles of Beer | Language English";

        EPage ePage = new EPage(getDriver());
        EnglishLanguagePage englishLanguagePage = new EnglishLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickESubmenu()
                .getURL();

        String newURL = ePage.clickEnglishLanguage().getURL();
        String actualTitle = englishLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, newURL);
        Assert.assertEquals(newURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
