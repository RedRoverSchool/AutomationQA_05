package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.JavaScriptLanguagePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptLanguageTest extends BaseTest {

    @Test
    public void testJavaScriptLanguagePageHeader() {
        final String expectedH2Header = "Language JavaScript";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testTableListNames() {
        final List<String> expectedListNames = new ArrayList<>(
                Arrays.asList("Date:", "Author:", "URL:", "Comments:", "Info:", "Score:"));

        List<String> actualListNames =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLanguage()
                        .getLanguageInfoFields();

        Assert.assertEquals(actualListNames, expectedListNames);
    }

    @Test
    public void testTableListValues() {
        final List<String> expectedListValues = new ArrayList<>(
                Arrays.asList("01/09/09", "JavaScribe", "n/a", "4",
                        "http://en.wikipedia.org/wiki/Javascript", "(3.04 in 374 votes)"));

        List<String> actualListValues =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLanguage()
                        .getLanguageInfoValues();

        Assert.assertEquals(actualListValues, expectedListValues);
    }

    @Test
    public void testJavaScriptInfoLink_NavigatesTo_JavaScriptLanguageWikiPage() {
        final String expectedExternalURL = "https://en.wikipedia.org/wiki/JavaScript";
        final String expectedExternalTitle = "JavaScript - Wikipedia";

        String oldJSLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLanguage()
                        .getURL();

        JavaScriptLanguagePage javaScriptLanguagePage = new JavaScriptLanguagePage(getDriver());

        javaScriptLanguagePage.clickJavaScriptLanguageInfoLink();

        Assert.assertNotEquals(oldJSLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }
}
