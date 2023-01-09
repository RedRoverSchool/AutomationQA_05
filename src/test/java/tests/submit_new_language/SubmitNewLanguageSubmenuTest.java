package tests.submit_new_language;

import testData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.submit_new_language.SubmitNewLanguageSubmenuPage;

import java.util.List;

public class SubmitNewLanguageSubmenuTest extends BaseTest {

    @Test(dataProviderClass = TestData.class, dataProvider = "newLanguageSubmenu")
    public void testFooterMenusNavigateToCorrespondingPages(
            int index, String submenuText, String href, String url, String title) {

        SubmitNewLanguageSubmenuPage submitNewLanguageSubmenuPage = openBaseURL().clickSubmitNewLanguageFooterMenu();

        List<WebElement> footerMenus = submitNewLanguageSubmenuPage.getSubmenus();

        String oldURL = submitNewLanguageSubmenuPage.getURL();
        String oldH2Text = submitNewLanguageSubmenuPage.getH2HeaderText();

        String actualUrl = submitNewLanguageSubmenuPage.clickMenu(index, footerMenus).getURL();
        String actualTitle = submitNewLanguageSubmenuPage.clickMenu(index, footerMenus).getTitle();
        String actualH2Text = submitNewLanguageSubmenuPage.clickMenu(index, footerMenus).getH2HeaderText();
        String actualSubmenu =  submitNewLanguageSubmenuPage.getTextSubmenu(index);
        String actualURLHref = submitNewLanguageSubmenuPage.getHref(index);

        Assert.assertEquals(actualUrl, oldURL);
        Assert.assertEquals(actualH2Text, oldH2Text);
        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualTitle, title);
        Assert.assertEquals(actualSubmenu, submenuText);
        Assert.assertEquals(actualURLHref, url);
    }
}
