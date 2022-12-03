package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImpressumPage extends StartSubmenuPage {

    @FindBy(xpath="//div[@id = 'main']/h2")
    private WebElement h2PrivacyHeader;

    @FindBy(xpath="//div[@id = 'main']/h3")
    private WebElement h3OliverSchadeHeader;

    public ImpressumPage(WebDriver driver) {
        super(driver);
    }

    public String getPrivacySubmenuText(){


        return getText(h2PrivacyHeader);
    }

    public String getOliverSchadeSubmenuText() {

        return getText(h3OliverSchadeHeader);
    }
}
