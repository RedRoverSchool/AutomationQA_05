package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPage extends StartSubmenuPage {

    public PrivacyPage(WebDriver driver) {
        super(driver);
    }

    public String getOliverSchadeSubmenuText() {

        return getH3HeadersTexts().get(0);
    }

    public String getEmailAddress() {

        return getFirstParagraphText();
    }
}
