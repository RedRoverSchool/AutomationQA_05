package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.JQueryLanguagePage;
import pages.browse_languages.languages.JRLanguagePage;
import pages.browse_languages.languages.JavaScriptLanguagePage;
import pages.browse_languages.letters.JPage;

public class JTest extends BaseTest {

    @Test
    public void testJQueryLink_NavigatesTo_JQueryLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-jquery-1361.html";
        final String expectedTitle = "99 Bottles of Beer | Language jQuery";

        JPage jPage = new JPage(getDriver());
        JQueryLanguagePage jQueryLanguagePage = new JQueryLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickJSubmenu()
                .getURL();

        String actualURL = jPage.clickJQueryLanguage().getURL();
        String actualTitle = jQueryLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testJavaScriptLink_NavigatesTo_JavaScriptLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-javascript-1948.html";
        final String expectedTitle = "99 Bottles of Beer | Language JavaScript";

        JPage jPage = new JPage(getDriver());
        JavaScriptLanguagePage javaScriptLanguagePage = new JavaScriptLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickJSubmenu()
                .getURL();

        String actualUrl = jPage.clickJavaScriptLanguage().getURL();
        String actualTitle = javaScriptLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, actualUrl);
        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testJRLink_NavigatesTo_JRLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-jr-999.html";
        final String expectedTitle = "99 Bottles of Beer | Language JR";

        JRLanguagePage jrLanguagePage = new JRLanguagePage(getDriver());

        String oldUrl = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickJSubmenu()
                .getURL();

        new JPage(getDriver()).clickJrLanguage();

        Assert.assertNotEquals(oldUrl, getDriver().getCurrentUrl());

        String actualURL = jrLanguagePage.getURL();
        String actualTitle = jrLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

