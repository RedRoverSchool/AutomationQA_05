package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.YacasLanguagePage;

public class YacasLanguageTest extends BaseTest {

    @Test
    public void testYacasLanguagePageHeader() {
        final String expectedH2Header = "Language Yacas";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickYSubmenu()
                        .clickYacasLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testVotingNiceCodingIsSelected() {

        final String expectedResult = "**** Nice Coding";

        YacasLanguagePage yacasLanguagePage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickYSubmenu()
                .clickYacasLanguage();

        String actualResult = yacasLanguagePage.getVotingFieldText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
