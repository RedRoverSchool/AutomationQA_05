package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.YacasLanguagePage;

public class YacasLanguageTest extends BaseTest {

    @Test
    public void testVotingNiceCodingIsSelected() {

        String expectedResult = "**** Nice Coding";

        YacasLanguagePage yacasLanguagePage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickYSubmenu()
                .clickYacasLink();

        String actualResult = yacasLanguagePage.getVotingFieldText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
