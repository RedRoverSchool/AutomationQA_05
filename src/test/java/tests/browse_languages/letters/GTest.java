package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.GapLanguagePage;
import pages.browse_languages.letters.GPage;

public class GTest extends BaseTest {

    @Test
    public void testGAPLanguageLink_NavigatesTo_GAPLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-gap-275.html";
        final String expectedTitle = "99 Bottles of Beer | Language GAP";

        GPage gPage = new GPage(getDriver());
        GapLanguagePage gapLanguagePage = new GapLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickGSubmenu()
                .getURL();

        String newURL = gPage.clickGapLanguage().getURL();
        String actualTitle = gapLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, newURL);
        Assert.assertEquals(newURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
