package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptLanguageTest extends BaseTest {

    @Test
    public void testJavaLanguagePageHeader() {
        String EXPECTED_JS_H2_HEADER = "Language JavaScript";

        String actualJSH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .clickJavaScriptLink()
                .getH2HeaderText();

        Assert.assertEquals(actualJSH2Header, EXPECTED_JS_H2_HEADER);
    }
}
