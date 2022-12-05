package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.SignV2Page;

import java.time.Duration;

public class SignV2Test extends BaseTest {
    @Test
    public void testSignGuestBookVerifyTextInAlertUrlandAcceptAlert(){
        final String urlAlertText = "http://my_text";
        openBaseURL().clickGuestbookMenu().clickSignGuestbook().clickUrlIcon();
        SignV2Page signV2Page = new SignV2Page(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(signV2Page.getAlertText(alert), "Enter the URL for the link you want to add.");
        signV2Page.acceptAlert(alert, urlAlertText);
    }
}
