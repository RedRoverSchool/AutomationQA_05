package tests.browse_languages.letters;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.YabasicLanguagePage;
import pages.browse_languages.languages.YacasLanguagePage;
import pages.browse_languages.letters.YPage;

import java.util.List;
import java.util.Random;

public class YTest extends BaseTest {

    @Test
    public void testAllLanguagesOnYPageStartWithLetterY() {
        final String letterY = "y";

        List<String> listYLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getNamesInLowerCase();

        Assert.assertTrue(listYLanguages.size() > 0);

        for (String languageName : listYLanguages) {
            Assert.assertTrue(languageName.contains(letterY));
        }
    }

    @Test
    public void testNumberOfLanguagesOnPageY() {
        final int expectedResult = 9;

        List<String> listYLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getNamesInLowerCase();

        Assert.assertEquals(listYLanguages.size(), expectedResult);
    }

    @Test
    public void testYabasicLink_NavigatesTo_YabasicLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-yabasic-64.html";
        final String expectedTitle = "99 Bottles of Beer | Language Yabasic";

        YPage yPage = new YPage(getDriver());
        YabasicLanguagePage yabasicLanguagePage = new YabasicLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickYSubmenu()
                .getURL();

        String actualURL = yPage.clickYabasicLanguage().getURL();
        String actualTitle = yabasicLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testYacasLink_NavigatesTo_YacasLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-yacas-65.html";
        final String expectedTitle = "99 Bottles of Beer | Language Yacas";

        YPage yPage = new YPage(getDriver());
        YacasLanguagePage yacasLanguagePage = new YacasLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickYSubmenu()
                .getURL();

        String actualURL = yPage.clickYacasLanguage().getURL();
        String actualTitle = yacasLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testRandomLinkNavigatesToCorrespondingPage() {
        List<WebElement> languageNames = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickYSubmenu()
                .getLanguagesLinks();

        Assert.assertTrue(languageNames.size() > 0);

        int r = new Random().nextInt(languageNames.size());

        YPage yPage = new YPage(getDriver());

        String languageName = yPage.getTextFromRandomLink(r, languageNames).toLowerCase();

        yPage.clickRandomLink(r, languageNames);

        Assert.assertTrue(getExternalPageURL().contains("language-" + languageName + "-")
                , getExternalPageTitle() + " doesn't contain " + languageName);
    }
}
