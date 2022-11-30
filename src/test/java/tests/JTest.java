package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JTest extends BaseTest {

    @Test
    public void testBrowseLanguagesLanguageSelectionH2HeaderTitle_HappyPath() {
        String EXPECTED_RESULT_H2_TITLE = "Language Java";

        String h2JavaTitle = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .clickJavaLanguage()
                .getH2JavaTitle();

        Assert.assertEquals(h2JavaTitle, EXPECTED_RESULT_H2_TITLE);
    }
}

