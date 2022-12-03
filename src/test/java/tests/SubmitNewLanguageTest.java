package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void testPleaseNoteItemsQuantity() {
        final int expectedItemsQuantity = 10;

        int actualItemsQuantity =
                openBaseURL()
                       .clickSubmitNewLanguageMenu()
                       .countPleaseNoteItems();

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
                .clickGoButton()
                .getLanguageCategorySelected();

        Assert.assertEquals(actualResultCategory,expectedResultCategory);
    }
}

