package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.JQueryLanguagePage;
import pages.browse_languages.letters.JPage;
import pages.top_lists.TopListAssemblyPage;
import pages.top_lists.TopListsPage;

public class TopListsTest extends BaseTest {

    @Test
    public void testH2HeaderText() {

        final String expectedResult = "Top Rated";

        String actualResult =
                openBaseURL()
                        .clickTopListsMenu()
                        .getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTopRatedAssemblySubmenu_NavigatesTo_TopRatedAssemblyPage() {

        final String expectedURL = "https://www.99-bottles-of-beer.net/toplist_assembly.html";
        final String expectedTitle = "99 Bottles of Beer | Top Rated Assembly Languages";

        TopListAssemblyPage TopListAssemblyPage = new TopListAssemblyPage(getDriver());

        String oldURL = openBaseURL()
                .clickTopListFooterMenu()
                .getTopListAssemblyPageURL();

        new TopListsPage(getDriver()).clickTopListAssemblyPageSubmenu();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = TopListAssemblyPage.getURL();
        String actualTitle = TopListAssemblyPage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
