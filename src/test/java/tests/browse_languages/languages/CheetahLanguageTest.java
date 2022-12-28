package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.CheetahLanguagePage;

public class CheetahLanguageTest extends BaseTest {

    @Test
    public void testCheetahLanguagePageHeader() {
        final String expectedH2Header = "Language Cheetah";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickCSubmenu()
                        .clickCheetahLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testCheetahInfoLink_NavigatesTo_ExternalCheetahLanguagePage() {
        final String expectedExternalURL = "https://cheetahtemplate.org/";
        final String expectedExternalTitle =
                "Cheetah3, the Python-Powered Template Engine — Cheetah3 - The Python-Powered Template Engine";

        String oldCheetahLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickCSubmenu()
                        .clickCheetahLanguage()
                        .getURL();

        CheetahLanguagePage cheetahLanguagePage = new CheetahLanguagePage(getDriver());

        cheetahLanguagePage.clickCheetahLanguageInfoLink();

        Assert.assertNotEquals(oldCheetahLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }
}
