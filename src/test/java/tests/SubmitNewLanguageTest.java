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
}

