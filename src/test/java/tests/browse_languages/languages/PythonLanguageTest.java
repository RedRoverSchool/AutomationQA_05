package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.PythonLanguagePage;

public class PythonLanguageTest extends BaseTest {

    @Test
    public void testPythonLanguagePageHeader() {
        final String expectedH2Header = "Language Python";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickPSubmenu()
                        .clickPythonLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testPythonOrgLink_NavigatesTo_ExternalPythonLanguagePage() {
        final String expectedExternalURL = "https://www.python.org/";
        final String expectedExternalTitle = "Welcome to Python.org";

        String oldPythonLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickPSubmenu()
                        .clickPythonLanguage()
                        .getURL();
        PythonLanguagePage pythonLanguagePage = new PythonLanguagePage(getDriver());

        pythonLanguagePage.clickPythonLanguageInfoLink();

        Assert.assertNotEquals(oldPythonLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }
}