package tests.start;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrivacyTest extends BaseTest {

    @Test
    public void testTextInHeaderH2() {
        String expectedH2Header = "Privacy";

        String actualTextInHeaderH2 =
                openBaseURL()
                        .clickPrivacySubmenu()
                        .getH2HeaderText();

        Assert.assertEquals(actualTextInHeaderH2, expectedH2Header);
    }

    @Test
    public void testEmail() {
        String expectedEmail = "os@ls-la.net";

        String actualEmail =
                openBaseURL()
                        .clickPrivacySubmenu()
                        .getEmailAddress();

        Assert.assertEquals(actualEmail, expectedEmail);
    }
    
    public void testTextInHeaderH3() {
        String expectedTextInHeaderH3 = "Oliver Schade";

        String actualTextInHeaderH3 =
                openBaseURL()
                        .clickPrivacySubmenu()
                        .getOliverSchadeSubmenuText();

        Assert.assertEquals(actualTextInHeaderH3, expectedTextInHeaderH3);
    }
}
