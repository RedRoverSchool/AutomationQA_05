package tests.guest_book;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestBookV2Test extends BaseTest {

    @Test
    public void testGuestbookMenuNavigatesToGuestbookPage() {
        final String expectedGuestbookUrl = "https://www.99-bottles-of-beer.net/guestbookv2.html";

        String actualGuestbookUrl = openBaseURL()
                .clickGuestbookMenu()
                .getDriver().getCurrentUrl();

        Assert.assertEquals(actualGuestbookUrl, expectedGuestbookUrl);
    }

    @Test
    public void testMainFooterGuestBookv2NavigatesToGuestbookPage() {
        final String urlKeyValue = "guest";

        String guestBoopPageURL = openBaseURL()
                .clickGuestBookFooterMenu()
                .getURL();

        Assert.assertTrue(guestBoopPageURL.contains(urlKeyValue));
    }
}
