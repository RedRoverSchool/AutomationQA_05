package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImpressumTest extends BaseTest {

    @Test
    public void testTextInHeaderH2() {
        String expectedTextInHeaderH2 = "Privacy";

        String actualTextInHeaderH2 =
                openBaseURL()
                        .clickPrivacySubmenu()
                        .getPrivacySubmenuText();

        Assert.assertEquals(actualTextInHeaderH2, expectedTextInHeaderH2);
    }

    @Test
    public void testTextInHeaderH3() {
        String expectedTextInHeaderH3 = "Oliver Schade";

        String actualTextInHeaderH3 =
                openBaseURL()
                        .clickPrivacySubmenu()
                        .getOliverSchadeSubmenuText();

        Assert.assertEquals(actualTextInHeaderH3, expectedTextInHeaderH3);
    }
}
