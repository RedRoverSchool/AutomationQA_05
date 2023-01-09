package tests;

import testData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.StartPage;

import java.util.ArrayList;
import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void testH1LogoHeader() {
        final String EXPECTED_H1_HEADER = "99 Bottles of Beer";

        String actualResultH1Header = openBaseURL().getH1LogoHeaderText();

        Assert.assertEquals(actualResultH1Header, EXPECTED_H1_HEADER);
    }

    @Test
    public void testH2LogoHeader() {
        final String EXPECTED_H2_HEADER = "one program in 1500 variations";

        String actualResultH2Header = openBaseURL().getH2LogoHeaderText();

        Assert.assertEquals(actualResultH2Header, EXPECTED_H2_HEADER);
    }

    @Test
    public void testTopMenuURLs_AreTheSameAs_FooterMenuURLs() {
        List<String> mainMenuURLList = new ArrayList<>();
        List<String> mainMenuFooterURLList = new ArrayList<>();

        StartPage startPage = new StartPage(getDriver());

        mainMenuURLList.add(openBaseURL().getURL());
        mainMenuURLList.add(startPage.clickBrowseLanguagesMenu().getURL());
        mainMenuURLList.add(startPage.clickSearchLanguagesMenu().getURL());
        mainMenuURLList.add(startPage.clickTopListsMenu().getURL());
        mainMenuURLList.add(startPage.clickGuestbookMenu().getURL());
        mainMenuURLList.add(startPage.clickSubmitNewLanguageMenu().getURL());

        mainMenuFooterURLList.add(openBaseURL().getURL());
        mainMenuFooterURLList.add(startPage.clickBrowseLanguagesFooterMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickSearchLanguagesFooterMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickTopListFooterMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickGuestBookFooterMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickSubmitNewLanguageFooterMenu().getURL());

        Assert.assertEquals(mainMenuURLList, mainMenuFooterURLList);
    }

    @Test
    public void testNavigationMenuLinksAmountAndTexts() {
        final int expectedAmount = 6;
        final String[] expectedTexts = {"Start", "Browse Languages", "Search Languages", "Top Lists", "Guestbook", "Submit new Language"};

        openBaseURL();
        StartPage startPage = new StartPage(getDriver());

        int actualAmount = startPage.getMenuLinksAmount();
        List<String> actualText = startPage.getMenuTextsInLowerCase();

        Assert.assertEquals(actualAmount, expectedAmount);
        for (int i = 0; i < actualText.size(); i++) {
            Assert.assertEquals(actualText.get(i), expectedTexts[i].toLowerCase());
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "MainTestData")
    public void testTopMenusNavigateToCorrespondingPages(
            int index, String menuText, String href, String url, String title) {

        StartPage startPage = openBaseURL();

        List<WebElement> topMenus = startPage.getTopMenuLinks();

        String oldURL = startPage.getURL();
        String oldTitle = startPage.getTitle();

        String actualUrl = startPage.clickMenu(index, topMenus).getURL();
        String actualTitle = startPage.clickMenu(index, topMenus).getTitle();

        if (index != 0) {
            Assert.assertNotEquals(actualUrl, oldURL);
            Assert.assertNotEquals(actualTitle, oldTitle);
        }
        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualTitle, title);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "MainTestData")
    public void testFooterMenusNavigateToCorrespondingPages(
            int index, String menuText, String href, String url, String title) {

        StartPage startPage = openBaseURL();

        List<WebElement> footerMenus = startPage.getFooterMenuLinks();

        String oldURL = startPage.getURL();
        String oldTitle = startPage.getTitle();

        String actualUrl = startPage.clickMenu(index, footerMenus).getURL();
        String actualTitle = startPage.clickMenu(index, footerMenus).getTitle();

        if (index != 0) {
            Assert.assertNotEquals(actualUrl, oldURL);
            Assert.assertNotEquals(actualTitle, oldTitle);
        }
        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualTitle, title);
    }
}
