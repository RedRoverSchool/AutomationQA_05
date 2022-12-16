package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YabasicLanguageTest extends BaseTest {

    @Test
    public void testYabasicLanguagePageHeader() {
        final String expectedH2Header = "Language Yabasic";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickYSubmenu()
                        .clickYabasicLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}
