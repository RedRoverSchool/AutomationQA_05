package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InfoSubmenuPage;

public class SubMenuInfoTest extends BaseTest {
    @Test
    public void testLabelTextSubmenuInfo(){
        final String expectedSubmenuInfoTitle = "History";

        openBaseURL();
        InfoSubmenuPage infoSubmenuPage = new InfoSubmenuPage(getDriver());

        String actualSubmenuTitle = infoSubmenuPage.getInfoSubMenuLabelText();

        Assert.assertEquals(actualSubmenuTitle, expectedSubmenuInfoTitle);
    }

    @Test
    public void testLinkTextSubmenuInfo(){
        final String attribute = "href";
        final String expectedSubmenuInfoLink = "info.html";

        openBaseURL();

        InfoSubmenuPage infoSubmenuPage = new InfoSubmenuPage(getDriver());

        String actualSubmenuInfoLink = infoSubmenuPage.getSubmenuInfoLink(attribute);

        Assert.assertTrue(actualSubmenuInfoLink.contains(expectedSubmenuInfoLink));
    }

    @Test
    public void testClickOnSubmenuInfo(){
        final String expectedSubmenuInfoURL = InfoSubmenuPage.getInfoSubmenuUrl();
        final String expectedSubmenuInfoTitle = "History";

        openBaseURL();

        String actualResultInfoURL = openBaseURL()
                .clickInfoSubmenuPage()
                .getDriver().getCurrentUrl();

        Assert.assertEquals(actualResultInfoURL, expectedSubmenuInfoURL);

        String actualSubmenuTitle = openBaseURL()
                .clickInfoSubmenuPage()
                .getInfoSubMenuLabelText();

        Assert.assertEquals(actualSubmenuTitle, expectedSubmenuInfoTitle);
    }
}
