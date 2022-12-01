package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GuestBookV2Page;

public class GuestBookV2Test extends BaseTest {
    final static String URL_KEY_VALUE = "guest";

    @Test
    public void testMainNavigationButtonGuestbook() {

        openBaseURL();
        GuestBookV2Page GuestBookV2Page = new GuestBookV2Page(getDriver());
        GuestBookV2Page.clickButtonGuestbookV2();
    }


    @Test
    public void test_MainFooterGuestBookv2_AramH20() {
        String guestBoopPageURL = openBaseURL().clickGuestBookMenu().getCurrentURL();
        Assert.assertTrue(guestBoopPageURL.contains(URL_KEY_VALUE));
    }
}
