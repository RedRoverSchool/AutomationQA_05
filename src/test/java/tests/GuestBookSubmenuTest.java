package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GuestBookSubmenuTest extends BaseTest {

    @Test
    public void testGuestbookSubmenuButtonsNames() {
        List<String> expectedGuestbookSubmenuButtonsNames = List.of("Sign Guestbook", "Read Guestbook");

        List<String> actualGuestbookSubmenuButtonsNames =
                openBaseURL()
                        .clickGuestbookMenu()
                        .getGuestbookSubmenus();

        Assert.assertEquals(actualGuestbookSubmenuButtonsNames, expectedGuestbookSubmenuButtonsNames);
    }
}
