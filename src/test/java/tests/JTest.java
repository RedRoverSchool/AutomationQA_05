package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.JRLanguagePage;
import pages.browse_languages.languages.JavaScriptLanguagePage;
import pages.browse_languages.letters.JPage;
import pages.browse_languages.languages.JQueryLanguagePage;

public class JTest extends BaseTest {

    @Test
    public void testJQueryLink_NavigatesTo_JQueryLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-jquery-1361.html";
        final String expectedTitle = "99 Bottles of Beer | Language jQuery";

        JQueryLanguagePage jQueryLanguagePage = new JQueryLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickJSubmenu()
                .getJPageURL();

        new JPage(getDriver()).clickJQueryLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = jQueryLanguagePage.getURL();
        String actualTitle = jQueryLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testJavaScriptLink_NavigatesTo_JavaScriptLanguagePage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-javascript-1948.html";
        final String expectedTitle = "99 Bottles of Beer | Language JavaScript";

        JavaScriptLanguagePage javaScriptLanguagePage = new JavaScriptLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickJSubmenu()
                .getJPageURL();

        new JPage(getDriver()).clickJavaScriptLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = javaScriptLanguagePage.getURL();
        String actualTitle = javaScriptLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testJRLink_NavigatesTo_JRLanguagePage(){

        final String expectedURL = "https://www.99-bottles-of-beer.net/language-jr-999.html";
        final String expectedTitle = "99 Bottles of Beer | Language JR";

        JRLanguagePage jrLanguagePage = new JRLanguagePage(getDriver());

        String oldUrl = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickJSubmenu()
                .getJPageURL();

        new JPage(getDriver()).clickJrLink();

        Assert.assertNotEquals(oldUrl, getDriver().getCurrentUrl());

        String actualURL = jrLanguagePage.getURL();
        String actualTitle = jrLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);






















    }
}

