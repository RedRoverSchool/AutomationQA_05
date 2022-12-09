package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.PythonLanguagePage;

public class PythonLanguageTest extends BaseTest {

    @Test
    public void testPythonOrgLink_NavigatesTo_ExternalPythonLanguagePage() {
        final String expectedExternalURL = "https://www.python.org/";
        final String expectedExternalTitle = "Welcome to Python.org";

        String oldPythonLanguagePageURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickPSubmenu()
                .clickPythonLink()
                .getURL();
        PythonLanguagePage pythonLanguagePage = new PythonLanguagePage(getDriver());

        pythonLanguagePage.clickPythonLanguageInfoLink();

        Assert.assertNotEquals(oldPythonLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }
}