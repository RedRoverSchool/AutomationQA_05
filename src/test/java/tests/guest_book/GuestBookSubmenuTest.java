package tests.guest_book;

import testData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.GuestbookSubmenuPage;

import java.util.List;

public class GuestBookSubmenuTest extends BaseTest {

    @Test
    public void testGuestbookSubmenusNames() {
        final List<String> expectedGuestbookSubmenusNames = List.of(
                "Sign Guestbook",
                "Read Guestbook"
        );

        List<String> actualGuestbookSubmenusNames =
                openBaseURL()
                        .clickGuestbookMenu()
                        .getGuestbookSubmenus();

        Assert.assertEquals(actualGuestbookSubmenusNames, expectedGuestbookSubmenusNames);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "GuestbookSubmenu")
    public void testGuestbookSubmenuNavigatesToCorrespondingPages(
            int index, String menuText, String href, String url, String title) {

            GuestbookSubmenuPage guestbookSubmenuPage = openBaseURL().clickGuestbookMenu();

            List<WebElement> guestbookSubmenus = guestbookSubmenuPage.getGuestbookSubmenusLinks();

            String oldURL = guestbookSubmenuPage.getURL();
            String oldTitle = guestbookSubmenuPage.getTitle();

            String actualURL = guestbookSubmenuPage.clickMenu(index, guestbookSubmenus).getURL();
            String actualTitle = guestbookSubmenuPage.clickMenu(index, guestbookSubmenus).getTitle();

            if (index != 1) {
                Assert.assertNotEquals(actualURL, oldURL);
                Assert.assertNotEquals(actualTitle, oldTitle);
            }

            Assert.assertEquals(actualURL, url);
            Assert.assertEquals(actualTitle, title);
    }
}
