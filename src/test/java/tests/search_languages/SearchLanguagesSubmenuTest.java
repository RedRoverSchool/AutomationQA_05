package tests.search_languages;

import testData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.search_languages.SearchLanguagesPage;

import java.util.List;

public class SearchLanguagesSubmenuTest extends BaseTest {

    @Test(dataProviderClass = TestData.class, dataProvider = "SearchLanguagesSubmenu")
    public void testSearchLanguagesSubmenuNavigateToCorrespondingPages(
            int index, String submenuText, String href, String url, String title) {

        SearchLanguagesPage searchLanguagesPage = openBaseURL().clickSearchLanguagesMenu();

        List<WebElement> searchLanguagesSubmenus =
                searchLanguagesPage
                        .getSearchLanguagesSubmenu();

        String actualNameSubmenu = searchLanguagesPage
                .getTextSearchLanguagesSubmenu(index);
        String oldUrl = searchLanguagesPage.getURL();
        String oldTitle = searchLanguagesPage.getTitle();

        String actualUrl = searchLanguagesPage
                .clickMenu(index, searchLanguagesSubmenus)
                .getURL();
        String actualTitle = searchLanguagesPage
                .clickMenu(index, searchLanguagesSubmenus)
                .getTitle();

        Assert.assertEquals(actualNameSubmenu, submenuText);
        Assert.assertEquals(actualUrl, oldUrl);
        Assert.assertEquals(actualTitle, oldTitle);

        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualTitle, title);
    }
}
