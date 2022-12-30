package tests.browse_languages.languages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.ABCPage;
import pages.browse_languages.letters.APage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubmenuLanguagesTest extends BaseTest {

    @Test
    public void testABCPagesLanguagesNameAndInformationColumn() {

        final List<String> expectedInfoColumn = Arrays.asList("Date:", "Author:", "URL:", "Comments:", "Info:", "Score:");
        APage apage = new APage(getDriver());
        List<WebElement> languagesSubmenus =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickASubmenu()
                        .getLanguagesLinks();
        List<String> submenusNames = apage.getNames();

        for (int i = 0; i < languagesSubmenus.size(); i++) {
            languagesSubmenus.get(i).click();
            String actualH2Header = apage.getH2HeaderText();
            String expectedH2Header = "Language " + submenusNames.get(i);
            List<String> actualInfoColumn = apage.languageInfoDates();

            Assert.assertEquals(actualInfoColumn, expectedInfoColumn);
            Assert.assertEquals(actualH2Header, expectedH2Header);
            apage.clickASubmenu();
        }
    }
}
