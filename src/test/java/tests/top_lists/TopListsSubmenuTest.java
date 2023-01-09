package tests.top_lists;

import testData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_lists.TopListsSubmenuPage;

import java.util.ArrayList;
import java.util.List;

public class TopListsSubmenuTest extends BaseTest {

    @Test
    public void testTopListsSubmenuTexts() {
        List<String> expectedSubmenuTexts = new ArrayList<>();
        expectedSubmenuTexts.add("Top Rated");
        expectedSubmenuTexts.add("Top Rated Real");
        expectedSubmenuTexts.add("Top Rated Esoteric");
        expectedSubmenuTexts.add("Top Rated Assembly");
        expectedSubmenuTexts.add("Top Hits");
        expectedSubmenuTexts.add("New Languages this month");
        expectedSubmenuTexts.add("New Comments");

        List<String> actualSubmenuTexts =
                openBaseURL()
                        .clickTopListsMenu()
                        .getSubmenusTexts();

        Assert.assertTrue(actualSubmenuTexts.size() > 0);
        Assert.assertEquals(actualSubmenuTexts, expectedSubmenuTexts);
    }

    @Test
    public void testTopListsSubMenuLinksNavigateToCorrectPages() {
        int expectedCountSubMenuLinks = 7;

        ArrayList<String> expectedSubmenuH2HeaderTexts = new ArrayList<>();
        expectedSubmenuH2HeaderTexts.add("Top Rated");
        expectedSubmenuH2HeaderTexts.add("Top Rated Real Languages");
        expectedSubmenuH2HeaderTexts.add("Top Rated Esoteric Languages");
        expectedSubmenuH2HeaderTexts.add("Top Rated Assembly Languages");
        expectedSubmenuH2HeaderTexts.add("Top Hits");
        expectedSubmenuH2HeaderTexts.add("New Languages this month");
        expectedSubmenuH2HeaderTexts.add("New Comments");

        int actualCountSubMenuLinks = openBaseURL()
                .clickTopListsMenu()
                .getSubmenusTexts().size();

        Assert.assertEquals(actualCountSubMenuLinks, expectedCountSubMenuLinks);

        ArrayList<String> actualSubmenuH2HeaderTexts = openBaseURL()
                .clickTopListsMenu()
                .clickTopListsSubmenuLinksAndGetH2Header();

        Assert.assertEquals(expectedSubmenuH2HeaderTexts, actualSubmenuH2HeaderTexts);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "TopListSubmenu")
    public void testSubMenuLinksNavigateToCorrespondingPages(
            int index, String title, String url) {

        TopListsSubmenuPage topListsSubmenuPage = openBaseURL()
                .clickTopListsMenu();

        List<WebElement> submenus = topListsSubmenuPage
                .getSubmenus();

        String actualUrl = topListsSubmenuPage
                .clickMenu(index, submenus)
                .getURL();

        String actualTitle = topListsSubmenuPage
                .clickMenu(index, submenus)
                .getTitle();

        Assert.assertEquals(actualUrl, url );
        Assert.assertEquals(actualTitle, title);
    }
}
