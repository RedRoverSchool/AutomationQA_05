package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
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
    public void testVerifyH2HeaderTest_SubmitNewLanguage() {
        final String expectedResult = "Submit New Language";

        String actualResult = openBaseURL()
                .clickSubmitNewLanguageMenu()
                .getTextH2Header();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
