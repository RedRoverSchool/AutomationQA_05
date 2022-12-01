package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubmitNewLanguagePage;

public class SubmitNewLanguageTest extends BaseTest {

    @Test
    public void testErrorMessageSubmitLanguageButton() {
        final String expectedResultErrorMessageSubmitLanguageButton = "Error: " +
                "Precondition failed - Incomplete Input.";

        String actualResultErrorMessageSubmitLanguageButton =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .clickGoButton()
                        .getTextErrorMessage();

        Assert.assertEquals(actualResultErrorMessageSubmitLanguageButton, expectedResultErrorMessageSubmitLanguageButton);

    }

    @Test
    public void testNavigationClickButtonSubmitNewLanguage() {
        String expectedResultSubmitNewLanguageUrl = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";

        openBaseURL();
        SubmitNewLanguagePage SubmitNewLanguagePage = new SubmitNewLanguagePage(getDriver());
        SubmitNewLanguagePage.clickSubmitNewLanguageMenu();

        String actualResultSubmitNewLanguageUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultSubmitNewLanguageUrl, expectedResultSubmitNewLanguageUrl);
    }

    @Test
    public void testFieldLanguageName() {
        final String INPUT_LANGUAGE_NAME = "Wizard";

        openBaseURL();
        SubmitNewLanguagePage SubmitNewLanguagePage = new SubmitNewLanguagePage(getDriver());
        SubmitNewLanguagePage.clickSubmitNewLanguageMenu();
        SubmitNewLanguagePage.clickFieldLanguageName();
        SubmitNewLanguagePage.inputFieldLanguageName(INPUT_LANGUAGE_NAME);
        SubmitNewLanguagePage.clickFieldDescription();
    }
}
