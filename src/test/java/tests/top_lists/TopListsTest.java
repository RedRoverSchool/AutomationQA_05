package tests.top_lists;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_lists.TopListsSubmenuPage;
import pages.top_lists.TopRatedAssemblyPage;

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

        TopRatedAssemblyPage TopRatedAssemblyPage = new TopRatedAssemblyPage(getDriver());

        String oldURL = openBaseURL()
                .clickTopListFooterMenu()
                .getTopListAssemblyPageURL();

        new TopRatedAssemblyPage(getDriver()).clickTopRatedAssemblyPageSubmenu();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = TopRatedAssemblyPage.getURL();
        String actualTitle = TopRatedAssemblyPage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
