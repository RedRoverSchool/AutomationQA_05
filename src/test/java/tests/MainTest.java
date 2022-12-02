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

        String actualResultH1Header = openBaseURL().getH1HeaderText();

        Assert.assertEquals(actualResultH1Header,EXPECTED_H1_HEADER);
    }

    @Test
    public void testH2Header() {
        final String EXPECTED_H2_HEADER = "one program in 1500 variations";

        String actualResultH2Header = openBaseURL().getH2HeaderText();

        Assert.assertEquals(actualResultH2Header,EXPECTED_H2_HEADER);
    }

    @Test
    public void testMainMenuURLEqualsFooterMenu() {
        List<String> mainMenuURLList = new ArrayList<>();
        List<String> mainMenuFooterURLList = new ArrayList<>();

        mainMenuURLList
                .add(openBaseURL()
                        .getPageURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getPageURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickSearchLanguagesMenu()
                        .getPageURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickTopListMenu()
                        .getPageURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickGuestbook()
                        .getPageURL());

        mainMenuURLList
                .add(openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .getPageURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickStartFooterMenu()
                        .getPageURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getPageURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickSearchLanguagesFooterMenu().getPageURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickTopListFooterMenu()
                        .getPageURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickGuestbookFooterMenu()
                        .getPageURL());

        mainMenuFooterURLList
                .add(openBaseURL()
                        .clickSubmitNewLanguageFooterMenu()
                        .getPageURL());

        Assert.assertEquals(mainMenuURLList, mainMenuFooterURLList);
    }
}
