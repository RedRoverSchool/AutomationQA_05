package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BashLanguagePage extends BasePage {

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement bashLanguageHeader;

    public BashLanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getBashLanguageHeader() {

        return getText(bashLanguageHeader);
    }
}
