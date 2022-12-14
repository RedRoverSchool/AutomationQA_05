package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnglishLanguageTest extends BaseTest {

    @Test
    public void testEnglishLanguagePageHeader() {
        final String expectedH2Header = "Language English";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickESubmenu()
                        .clickEnglishLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}
