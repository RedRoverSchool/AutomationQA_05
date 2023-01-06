package tests.submit_new_language;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.submit_new_language.SubmitNewLanguagePage;

import java.util.List;

public class SubmitNewLanguageTest extends BaseTest {

    @Test
    public void testErrorMessageSubmitLanguageButton() {
        final String expectedResultErrorMessageSubmitLanguageButton =
                "Error: Precondition failed - Incomplete Input.";

        String actualResultErrorMessageSubmitLanguageButton =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .clickSubmitLanguageButton()
                        .getErrorMessageText();

        Assert.assertEquals(actualResultErrorMessageSubmitLanguageButton, expectedResultErrorMessageSubmitLanguageButton);
    }

    @Test
    public void testPleaseNoteItemsQuantity() {
        final int expectedItemsQuantity = 10;

        int actualItemsQuantity =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .countBullets();

        Assert.assertEquals(actualItemsQuantity, expectedItemsQuantity);
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

        Assert.assertEquals(actualResultCategory, expectedResultCategory);
    }

    @Test
    public void testCaptchaErrorMessage() {
        final String LANGUAGE = "java";
        final String AUTHOR = "tester";
        final String EMAIL = "jka59433@xcoxc.com";
        final String CAPTCHA = "1";
        final String CODE = "String";
        final String ERROR_REASON = "Invalid security code";
        final String PROMPT_COLOUR = "red";

        SubmitNewLanguagePage submitNewLanguagePage = openBaseURL()
                .clickSubmitNewLanguageFooterMenu()
                .inputLanguage(LANGUAGE)
                .inputAuthor(AUTHOR)
                .inputEmail(EMAIL)
                .inputCaptcha(CAPTCHA)
                .inputCode(CODE)
                .clickSubmitLanguageButton();

        String actualResultErrorMessage = submitNewLanguagePage.getErrorMessageText();
        String actualResultPrompt = submitNewLanguagePage.getCaptchaStyle();

        Assert.assertTrue(actualResultErrorMessage.contains(ERROR_REASON));
        Assert.assertTrue(actualResultPrompt.contains(PROMPT_COLOUR));
    }

    @Test
    public void testIncludesLanguageCategory() {
        final List<String> expectedIncludesLanguageCategory = List.of(
                "real language", "esoteric language", "assembly language");

        List<String> actualIncludesLanguageCategory =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .clickCategoryField()
                        .getCategoryTexts();

        Assert.assertEquals(actualIncludesLanguageCategory, expectedIncludesLanguageCategory);
    }

    @Test
    public void testImportantText() {
        final String expectedImportant = "IMPORTANT:";

        String actualImportant =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .getImportantText();

        Assert.assertEquals(actualImportant, expectedImportant);
    }

    @Test
    public void testImportantTextFontAndColors() {
        final String expectedImportantFont = "700";
        final String expectedImportantBackgroundColor = "rgba(0, 0, 0, 0)";
        final String expectedImportantColor = "rgba(255, 255, 255, 1)";

        SubmitNewLanguagePage submitNewLanguagePage =
                openBaseURL()
                        .clickSubmitNewLanguageMenu();

        String actualImportantFont =
                submitNewLanguagePage
                        .getImportantFont();

        String actualImportantBackgroundColor =
                submitNewLanguagePage
                        .getImportantBackgroundColor();

        String actualImportantColor =
                submitNewLanguagePage
                        .getImportantColor();

        Assert.assertEquals(actualImportantFont, expectedImportantFont);
        Assert.assertEquals(actualImportantBackgroundColor, expectedImportantBackgroundColor);
        Assert.assertEquals(actualImportantColor, expectedImportantColor);
    }

    @Test
    public void testRequiredFieldsCircledRedWhenClickingButtonSubmitLanguage() {
        final String expectedBorderOfRequiredFieldLanguage = "1px solid rgb(255, 0, 0)";
        final String expectedBorderOfRequiredFieldAuthor = "1px solid rgb(255, 0, 0)";
        final String expectedBorderOfRequiredFieldEmail = "1px solid rgb(255, 0, 0)";
        final String expectedBorderOfRequiredFieldCaptcha = "1px solid rgb(255, 0, 0)";
        final String expectedBorderOfRequiredFieldCode = "1px solid rgb(255, 0, 0)";

        SubmitNewLanguagePage submitNewLanguagePage =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .clickSubmitLanguageButton();

        String actualBorderOfRequiredFieldLanguage =
                submitNewLanguagePage
                        .getLanguageBorder();

        String actualBorderOfRequiredFieldAuthor =
                submitNewLanguagePage
                        .getAuthorBorder();

        String actualBorderOfRequiredFieldEmail =
                submitNewLanguagePage
                        .getEmailBorder();

        String actualBorderOfRequiredFieldCaptcha =
                submitNewLanguagePage
                        .getCaptchaBorder();

        String actualBorderOfRequiredFieldCode =
                submitNewLanguagePage
                        .getCodeBorder();

        Assert.assertEquals(actualBorderOfRequiredFieldLanguage, expectedBorderOfRequiredFieldLanguage);
        Assert.assertEquals(actualBorderOfRequiredFieldAuthor, expectedBorderOfRequiredFieldAuthor);
        Assert.assertEquals(actualBorderOfRequiredFieldEmail, expectedBorderOfRequiredFieldEmail);
        Assert.assertEquals(actualBorderOfRequiredFieldCaptcha, expectedBorderOfRequiredFieldCaptcha);
        Assert.assertEquals(actualBorderOfRequiredFieldCode, expectedBorderOfRequiredFieldCode);
    }

    @Test
    public void testNumberRequiredFieldWithRedBorder() {
        final int expectedNumberRequiredFieldWithRedBorder = 5;

        int actualNumberRequiredFieldWithRedBorder =
                openBaseURL()
                        .clickSubmitNewLanguageMenu()
                        .clickSubmitLanguageButton()
                        .countRequiredFields();

        Assert.assertEquals(actualNumberRequiredFieldWithRedBorder, expectedNumberRequiredFieldWithRedBorder);
    }
}
