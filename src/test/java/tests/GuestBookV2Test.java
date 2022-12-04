package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.guest_book.GuestBookV2Page;

public class GuestBookV2Test extends BaseTest {

    @Test
    public void testMainNavigationButtonGuestbook() {

        openBaseURL();
        GuestBookV2Page GuestBookV2Page = new GuestBookV2Page(getDriver());
        GuestBookV2Page.clickButtonGuestbookV2();
    }
}
