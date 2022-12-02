package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.FindException;

public class ImpressumPage extends StartSubmenuPage {

    @FindBy(xpath="//div[@id = 'main']/h2")
    private WebElement h2PrivacyHeader;

    public ImpressumPage(WebDriver driver) {
        super(driver);
    }

    public String getPrivacySubmenuText(){
        return getText(h2PrivacyHeader);
    }
}
