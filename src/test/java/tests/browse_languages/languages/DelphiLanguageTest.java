package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DelphiLanguageTest extends BaseTest {

    @Test
    public void testDelphiLanguagePageHeader() {
        final String expectedH2Header = "Language Delphi";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickDSubmenu()
                        .clickDelphiLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}
