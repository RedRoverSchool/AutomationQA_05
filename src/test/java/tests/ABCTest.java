package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABCTest extends BaseTest {

    @Test
    public void testVerifyingFooterChoosingLanguage() {
        final String LANGUAGE_NAME = "BASH";

        String actualLanguageName = openBaseURL()
                .clickBrowseLanguagesMenuFooter()
                .clickBLink()
                .clickBashLink()
                .getTextBASH();

        Assert.assertTrue(actualLanguageName.contains(LANGUAGE_NAME));
    }
}
