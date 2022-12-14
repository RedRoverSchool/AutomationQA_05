package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.submit_new_language.SubmitNewLanguagePage;

public class SubmitNewLanguageTest extends BaseTest {

    @Test
    public void testErrorMessageSubmitLanguageButton() {
        final String expectedResultErrorMessageSubmitLanguageButton = "Error: " +
                "Precondition failed - Incomplete Input.";

        String actualResultErrorMessageSubmitLanguageButton =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .clickSubmitLanguageButton()
                        .getErrorMessage();

        Assert.assertEquals(actualResultErrorMessageSubmitLanguageButton, expectedResultErrorMessageSubmitLanguageButton);
    }

    @Test
    public void testPleaseNoteItemsQuantity() {
        final int expectedItemsQuantity = 10;

        int actualItemsQuantity =
                openBaseURL()
                       .clickSubmitNewLanguageMenu()
                       .countBullets();

        Assert.assertEquals(actualItemsQuantity,expectedItemsQuantity);
    }
  
    @Test
    public void testH2Header_SubmitNewLanguage() {
        final String expectedResult = "Submit New Language";

        String actualResult = openBaseURL()
                .clickSubmitNewLanguageMenu()
                .getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLanguageCategories_WhenSubmittingANewLanguage() {
        String expectedResultCategory = "esoteric language";

        String actualResultCategory = openBaseURL()
                .clickSubmitNewLanguageFooterMenu()
                .clickCategoryField()
                .clickEsotericLanguageOption()
                .clickSubmitLanguageButton()
                .getSelectedLanguageCategory();

        Assert.assertEquals(actualResultCategory,expectedResultCategory);
    }

    @Test
    public void testCaptchaErrorMessage () {
        final String LANGUAGE = "java";
        final String AUTHOR = "tester";
        final String EMAIL = "jka59433@xcoxc.com";
        final String CAPTCHA = "1";
        final String CODE = "String";
        final String ERROR_REASON = "Invalid security code";
        final String PROMPT_COLOUR = "red";

        openBaseURL()
                .clickSubmitNewLanguageFooterMenu()
                .inputLanguage(LANGUAGE)
                .inputAuthor(AUTHOR)
                .inputEmail(EMAIL)
                .inputCaptcha(CAPTCHA)
                .inputCode(CODE)
                .clickGoButton();

        SubmitNewLanguagePage submitNewLanguagePage = new SubmitNewLanguagePage(getDriver());

        String actualResultErrorMessage = submitNewLanguagePage.getErrorMessage();
        String actualResultPrompt = submitNewLanguagePage.getCaptchaStyle();

        Assert.assertTrue(actualResultErrorMessage.contains(ERROR_REASON));
        Assert.assertTrue(actualResultPrompt.contains(PROMPT_COLOUR));
    }
}

