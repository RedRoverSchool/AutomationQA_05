package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.JQueryLanguagePage;

public class JQueryLanguageTest extends BaseTest {

    @Test
    public void testJQueryLanguagePageHeader() {
        final String expectedH2Header = "Language jQuery";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickJSubmenu()
                        .clickJQueryLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testJQueryInfoLink_NavigatesTo_ExternalJQueryLanguagePage() {
        final String expectedExternalURL = "https://jquery.com/";
        final String expectedExternalTitle = "jQuery";

        String oldJQueryLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJQueryLanguage()
                        .getURL();

        JQueryLanguagePage jQueryLanguagePage = new JQueryLanguagePage(getDriver());

        jQueryLanguagePage.clickJQueryLanguageInfoLink();

        Assert.assertNotEquals(oldJQueryLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }
}
