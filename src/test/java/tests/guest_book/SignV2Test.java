package tests.guest_book;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.SignGuestbookPage;

import java.time.Duration;

public class SignV2Test extends BaseTest {
    @Test
    public void testSignGuestBookVerifyTextInAlertUrlandAcceptAlert(){
        final String urlAlertText = "http://my_text";
        openBaseURL().clickGuestbookMenu().clickSignGuestbook().clickUrlIcon();
        SignGuestbookPage signV2Page = new SignGuestbookPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(signV2Page.getAlertText(alert), "Enter the URL for the link you want to add.");
        signV2Page.acceptAlert(alert, urlAlertText);
    }

    @Test
    public void testErrorMessageIfSubmitWithoutCaptcha(){
        final String name = "Guest";
        final String email = "guest@gmail.com";
        final String message = "it is a message";
        final String expectedErrorMessage = "Error: Please enter at least a message, your email address and the security code.";

        String actualErrorMessage =
                openBaseURL()
                        .clickGuestbookMenu()
                        .clickSignGuestbook()
                        .inputName(name)
                        .inputMessage(message)
                        .inputEmail(email)
                        .clickSubmitButton().getErrorMessageText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}
