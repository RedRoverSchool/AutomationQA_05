package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.ScalaLanguagePage;
import pages.browse_languages.letters.SPage;

public class STest extends BaseTest {
    @Test
    public void testScalaLink_NavigatesTo_ScalaLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-scala-2179.html";
        final String expectedTitle = "99 Bottles of Beer | Language Scala";

        SPage sPage = new SPage(getDriver());
        ScalaLanguagePage scalaLanguagePage = new ScalaLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickSSubmenu()
                .getURL();

        String actualURL = sPage.clickScalaLanguage().getURL();
        String actualTitle = scalaLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
