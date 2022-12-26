package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KalkulonLanguageTest extends BaseTest {

    @Test
    public void testKalkulonLanguagePageHeader() {
        final String expectedH2Header = "Language Kalkulon";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKalkulonLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}
