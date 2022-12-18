package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BashLanguagePage extends LanguagePage {

    @FindBy(xpath = "//a[@href='http://fr.lang.free.fr/cours']")
    private WebElement bashLanguageInfoLink;

    public BashLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickBashLanguageInfoLink() {
        click(bashLanguageInfoLink);
    }
}
