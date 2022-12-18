package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdaLanguageTest extends BaseTest {

    @Test
    public void testAdaLanguagePageHeader() {
        final String expectedH2Header = "Language Ada";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickASubmenu()
                        .clickAdaLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}
