package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JPage;
import pages.JQueryLanguagePage;

public class JTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolJ() {
        final String symbol = "J";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category J";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/j.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }

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
}

