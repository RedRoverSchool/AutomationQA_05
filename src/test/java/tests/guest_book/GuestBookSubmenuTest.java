package tests.guest_book;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
