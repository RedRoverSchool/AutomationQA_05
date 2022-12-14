package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.AdaLanguagePage;

public class AdaLanguageTest extends BaseTest {

    @Test
    public void testChoosingLanguageAda() {
        final String expectedLanguageName = "Language Ada";

        AdaLanguagePage adaLanguagePage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .clickAdaLanguage();

        Assert.assertEquals(adaLanguagePage.getH2HeaderText(), expectedLanguageName);
    }
}
