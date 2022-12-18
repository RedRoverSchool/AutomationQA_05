package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaLanguageTest extends BaseTest {

    @Test
    public void testJavaLanguagePageHeader() {
        final String expectedH2Header = "Language Java";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}
