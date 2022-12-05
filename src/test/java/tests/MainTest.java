package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        mainMenuURLList
                .add(openBaseURL()
                        .getURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickSearchLanguagesMenu()
                        .getURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickTopListsMenu()
                        .getURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickGuestbookMenu()
                        .getURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .getURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickStartFooterMenu()
                        .getURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickSearchLanguagesFooterMenu()
                        .getURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickTopListFooterMenu()
                        .getURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickGuestBookFooterMenu()
                        .getURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickSubmitNewLanguageFooterMenu()
                        .getURL());

        Assert.assertEquals(mainMenuURLList, mainMenuFooterURLList);
    }

    @Test
    public void testH2TagTextHeaderMain() {
        final String expectedResult = "one program in 1500 variations";

        String actualResult = openBaseURL().getH2LogoHeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
