package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JQueryLanguagePage extends LanguagePage {

    @FindBy(xpath = "//a[@href='http://jquery.com']")
    private WebElement jQueryLanguageInfoLink;

    public JQueryLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickJQueryLanguageInfoLink() {
        click(jQueryLanguageInfoLink);
    }
}
