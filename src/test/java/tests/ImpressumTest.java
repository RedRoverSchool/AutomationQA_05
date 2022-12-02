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
    public void testTextOnThePageImpressum() {
        String expectedTextEmailAdressOnThePage = "os@ls-la.net";

        String actualTextEmailAdressOnThePage =
                openBaseURL()
                        .clickPrivacySubmenu()
                        .getTextEmailAdressOnThePage();

        Assert.assertEquals(actualTextEmailAdressOnThePage, expectedTextEmailAdressOnThePage);

    }
}
