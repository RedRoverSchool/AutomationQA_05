package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.BashLanguagePage;

public class BPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-bash-1815.html']")
    private WebElement bashLanguage;

    public BPage(WebDriver driver) {
        super(driver);
    }

    public BashLanguagePage clickBashLanguage() {
        click(bashLanguage);

        return new BashLanguagePage(getDriver());
    }
}
