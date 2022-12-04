package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaLanguageTest extends BaseTest {

    @Test
    public void testJavaLanguagePageHeader() {
        String EXPECTED_H2_HEADER = "Language Java";

        String actualH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .clickJavaLink()
                .getJavaLanguagePageHeader();

        Assert.assertEquals(actualH2Header, EXPECTED_H2_HEADER);
    }
}
