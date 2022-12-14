package pages.start;

import org.openqa.selenium.WebDriver;

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
