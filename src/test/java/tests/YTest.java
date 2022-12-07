package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.YabasicLanguagePage;
import pages.browse_languages.letters.YPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void testVerifyNavigationSymbolY() {
        final String symbol = "Y";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category Y";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/y.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }

    @Test
    public void testTableHeaderNames() {

        List<String> expectedHeaderNames = new ArrayList<>(
                Arrays.asList("Language", "Author", "Date", "Comments", "Rate"));

        List<String> actualHeaderNames =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getTableHeaderNames();

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
                .getYPageURL();

        new YPage(getDriver()).clickYabasicLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = yabasicLanguagePage.getURL();
        String actualTitle = yabasicLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
