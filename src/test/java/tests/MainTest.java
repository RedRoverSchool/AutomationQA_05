package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.StartPage;

import java.util.ArrayList;
import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void testH1Header() {
        final String EXPECTED_H1_HEADER = "99 Bottles of Beer";

        String actualResultH1Header = openBaseURL().getH1LogoHeaderText();

        Assert.assertEquals(actualResultH1Header, EXPECTED_H1_HEADER);
    }

    @Test
    public void testH2Header() {
        final String EXPECTED_H2_HEADER = "one program in 1500 variations";

        String actualResultH2Header = openBaseURL().getH2LogoHeaderText();

        Assert.assertEquals(actualResultH2Header, EXPECTED_H2_HEADER);
    }

    @Test
    public void testMainMenuURLEqualsFooterMenu() {
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
        mainMenuFooterURLList.add(startPage.clickBrowseLanguagesMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickSearchLanguagesMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickTopListsMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickGuestbookMenu().getURL());
        mainMenuFooterURLList.add(startPage.clickSubmitNewLanguageMenu().getURL());

        Assert.assertEquals(mainMenuURLList, mainMenuFooterURLList);
    }
}
