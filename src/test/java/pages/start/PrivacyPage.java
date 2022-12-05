package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPage extends StartSubmenuPage {

    @FindBy(xpath="//div[@id = 'main']/p")
    private WebElement textEmailAdressOnThePage;

    @FindBy(xpath="//div[@id = 'main']/h3")
    private WebElement h3OliverSchadeHeader;

    public PrivacyPage(WebDriver driver) {
        super(driver);
    }

    public String getOliverSchadeSubmenuText() {

        return getText(h3OliverSchadeHeader);
    }

    public String getTextEmailAddressOnThePage() {

        return getText(textEmailAdressOnThePage);
    }
}
