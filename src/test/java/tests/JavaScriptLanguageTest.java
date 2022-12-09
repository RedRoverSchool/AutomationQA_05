package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptLanguageTest extends BaseTest {

    @Test
    public void testJavaScriptLanguagePageHeader() {
        String EXPECTED_JS_H2_HEADER = "Language JavaScript";

        String actualJSH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .clickJavaScriptLink()
                .getH2HeaderText();

        Assert.assertEquals(actualJSH2Header, EXPECTED_JS_H2_HEADER);
    }

    @Test
    public void testTableListNames() {

        List<String> expectedListNames = new ArrayList<>(
                Arrays.asList("Date:", "Author:", "URL:", "Comments:", "Info:", "Score:"));

        List<String> actualListNames =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLink()
                        .getTableListNames();

        Assert.assertEquals(actualListNames, expectedListNames);
    }

    @Test
    public void testTableListValues() {

        List<String> expectedListValues = new ArrayList<>(
                Arrays.asList("01/09/09", "JavaScribe", "n/a", "4",
                        "http://en.wikipedia.org/wiki/Javascript", "(3.04 in 373 votes)"));

        List<String> actualListValues =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLink()
                        .getTableListValues();

        Assert.assertEquals(actualListValues, expectedListValues);
    }

    @Test
    public void testJSDeepLinkText() {

        final String attribute = "href";
        final String expectedDeepLink = "http://en.wikipedia.org/wiki/Javascript";

        String actualDeepLink =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLink()
                        .getHrefDeepLink(attribute);

        Assert.assertEquals(actualDeepLink, expectedDeepLink);
    }
}
