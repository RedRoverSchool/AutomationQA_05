package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.browse_languages.languages.YabasicLanguagePage;
import pages.browse_languages.languages.YacasLanguagePage;
import pages.browse_languages.letters.JPage;
import pages.browse_languages.letters.YPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class YTest extends BaseTest {

    @Test
    public void testAllLanguagesOnYPageStartWithLetterY()  {
        final String letterY = "y";

        List<String> listYLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getNamesInLowerCase();

        Assert.assertTrue(listYLanguages.size() > 0);

        for (String languageName: listYLanguages) {
            Assert.assertTrue(languageName.contains(letterY));
        }
    }

    @Test
    public void testVerifyNumberOfLanguagesOnPageY()  {
        final int expectedResult = 9;
        int count = 0;

        List<String> listYLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getNamesInLowerCase();

        for (String languageName : listYLanguages) {
           if ((listYLanguages.size() > 0 && languageName.charAt(0) == 'y')) {
               count++;
           }
        }

        int actualResult = count;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTableHeaderNames() {

        List<String> expectedHeaderNames = new ArrayList<>(
                Arrays.asList("Language", "Author", "Date", "Comments", "Rate"));

        List<String> actualHeaderNames =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getHeaders();

        Assert.assertEquals(actualHeaderNames, expectedHeaderNames);
    }

    @Test
    public void testYabasicLink_NavigatesTo_YabasicLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-yabasic-64.html";
        final String expectedTitle = "99 Bottles of Beer | Language Yabasic";

        YabasicLanguagePage yabasicLanguagePage = new YabasicLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickYSubmenu()
                .getURL();

        new YPage(getDriver()).clickYabasicLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = yabasicLanguagePage.getURL();
        String actualTitle = yabasicLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testYacasLink_NavigatesTo_YacasLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-yacas-65.html";
        final String expectedTitle = "99 Bottles of Beer | Language Yacas";

        YacasLanguagePage yacasLanguagePage = new YacasLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickYSubmenu()
                .getURL();

        new YPage(getDriver()).clickYacasLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = yacasLanguagePage.getURL();
        String actualTitle = yacasLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Ignore
    @Test
    public void testRandomLinkNavigatesToCorrespondingPage() {

        List<WebElement> languageNames = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .getLanguagesLinks();

        Assert.assertTrue(languageNames.size() > 0, "listSize <= 0");

        int r = new Random().nextInt(languageNames.size());

        JPage jPage = new JPage(getDriver());

        String languageName = jPage.getTextFromRandomLink(r, languageNames).toLowerCase();

        jPage.clickRandomLink(r, languageNames);

        Assert.assertTrue(getExternalPageURL().contains("language-" + languageName + "-"), getExternalPageTitle() + "doesn't contain" + languageName);
    }
}
